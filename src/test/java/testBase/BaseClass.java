package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public BaseClass() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator+"log4j.properties");
	}

	public Logger LOGGER = Logger.getLogger(BaseClass.class);
	Properties prop;
	public WebDriver driver;
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	@SuppressWarnings("deprecation")
	@Parameters(value = { "browser", "OS", "Platform", "Version", "url" })
	@BeforeMethod
	public void setUp(String browser, String OS, Platform platform, String version, String url) {
		Properties prop = new Properties();
		prop = properties();
		HashMap<String, Object> ltOptions;
		String hubUrl = prop.getProperty("hubUrl");
		String username = prop.getProperty("username");
		String accesskey = "9xHnsL4HgsvH1odOxDlYU0ZDEBPsb7HHyyksNSRjYZUZYzKmhG";
		String location = prop.getProperty("environment").toLowerCase();

		if (location.equalsIgnoreCase("remote")) {
			switch (OS.toUpperCase()) {
			case "WINDOWS": {
				desiredCapabilities.setPlatform(platform);
				desiredCapabilities.setVersion(version);
				// desiredCapabilities.setCapability(Platform.WIN10);
				ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", username);
				ltOptions.put("accessKey", accesskey);
				ltOptions.put("visual", true);
				ltOptions.put("video", true);
				ltOptions.put("network", true);
				ltOptions.put("project", "LambdaTest101");
				// ltOptions.put("tunnel", true);
				ltOptions.put("w3c", true);
				desiredCapabilities.setCapability("LT:Options", ltOptions);
				System.out.print("Window Machine is set");
				break;
			}

			case "MACOS": {
				desiredCapabilities.setPlatform(platform);
				desiredCapabilities.setVersion(version);
				ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", username);
				ltOptions.put("accessKey", accesskey);
				ltOptions.put("visual", true);
				ltOptions.put("video", true);
				ltOptions.put("network", true);
				ltOptions.put("project", "LambdaTest101");
				// ltOptions.put("tunnel", true);
				ltOptions.put("w3c", true);
				desiredCapabilities.setCapability("LT:Options", ltOptions);
				System.out.print("Macos OS is set");
				break;
			}

			case "LINUX": {
				desiredCapabilities.setPlatform(platform);
				desiredCapabilities.setVersion(version);;
				ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", username);
				ltOptions.put("accessKey", accesskey);
				ltOptions.put("visual", true);
				ltOptions.put("video", true);
				ltOptions.put("network", true);
				ltOptions.put("project", "LambdaTest101");
				// ltOptions.put("tunnel", true);
				ltOptions.put("w3c", true);
				desiredCapabilities.setCapability("LT:Options", ltOptions);
				break;
			}

			default: {
				System.out.print("No platfrom found");
				driver = null;
				LOGGER.error("No platfrom found with name " + OS);
			}
			}
			switch (browser.toLowerCase()) {
			case "chrome": {
				desiredCapabilities.setBrowserName("chrome");
				System.out.print("Chrome is set");
				break;
			}
			case "firefox": {
				desiredCapabilities.setBrowserName("firefox");
				System.out.print("Firefox is set");
				break;
			}
			case "edge":
				desiredCapabilities.setBrowserName("MicrosoftEdge");
				break;
			case "safari":
				desiredCapabilities.setBrowserName("safari");
				break;
			case "ie":
				desiredCapabilities.setBrowserName("ie");
				break;
			default: {
				System.out.print("No driver found");
				driver = null;
				LOGGER.error("No Browser found with name " + browser);
			}
			}
			try {
				driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + hubUrl),
						desiredCapabilities);
			} catch (MalformedURLException e) {
				LOGGER.error(e.getMessage());
			}
		} else if (location.equalsIgnoreCase("local")) {

			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.print("No driver found");
				driver = null;
				LOGGER.error("No Browser found with name " + browser);
			}
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
		driver.quit();;
	}

	public Properties properties() {
		try {
			FileReader fileReader = new FileReader(
					System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config.properties");
			LOGGER.info("Properties file for config is picked from " + System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config.properties");
			prop = new Properties();
			prop.load(fileReader);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return prop;

	}

}
