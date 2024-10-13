package testBase;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.TestContext;
import utilities.TestHelper;

public class BaseClass {
	public BaseClass() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");
	}

	public Logger LOGGER = Logger.getLogger(BaseClass.class);
	
	public WebDriver driver;
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	TestContext testContext;
	
	@Parameters(value = { "browser", "OS", "Platform", "Version", "url" })
	@BeforeMethod
	public void setUp(String browser, String OS, Platform platform, String version, String url) {
		testContext= new TestContext();
		testContext.initlizePageObjects(driver);
		Properties prop= testContext.getPropertiesFile().properties();
		
		String location = prop.getProperty("environment").toLowerCase();
		TestHelper testHelper = new TestHelper(desiredCapabilities);

		if (location.equalsIgnoreCase("remote")) {

			driver=testHelper.switchToRemoteWindow(driver,browser, OS, platform, version);
		
		} else if (location.equalsIgnoreCase("local")) {

			driver = testHelper.switchToLocalBrowser(driver, browser);

		}

		driver.manage().window().maximize();
		LOGGER.info("Window is maximized");
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implcitiWait"))));
		LOGGER.info("Implicit wait is applied for " + Integer.parseInt(prop.getProperty("implcitiWait")));
		driver.get(url);
	}

	@AfterMethod
	public void closeCurrentBrowser() {

		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			LOGGER.error("Exception " + e.getMessage() + " occured");
		}

	}

	

}
