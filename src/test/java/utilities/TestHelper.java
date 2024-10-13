package utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestHelper {
	DesiredCapabilities desiredCapabilities;
	TestContext testContext;

	public TestHelper(DesiredCapabilities desiredCapabilities) {
		this.desiredCapabilities = desiredCapabilities;
	}

	public Logger LOGGER = Logger.getLogger(TestHelper.class);

	public WebDriver switchToRemoteWindow(WebDriver driver, String browser, String OSDetails, Platform platform,
			String version) {
		testContext = new TestContext();
		testContext.initlizePageObjects(driver);
		String username = testContext.getPropertiesFile().properties().getProperty("username");
		String accesskey = "27Nfzhs9xd6Ho3gBy7sxSTMgLfzrGRgQNJ4HbsIkfV9lPlQ7vQ";
		String hubUrl = testContext.getPropertiesFile().properties().getProperty("hubUrl");
		HashMap<String, Object> ltOptions;
		switch (OSDetails.toUpperCase()) {
		case "WINDOWS": {
			desiredCapabilities.setPlatform(platform);
			desiredCapabilities.setVersion(version);
			// desiredCapabilities.setCapability(Platform.VENTURA);
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
			break;
		}

		default: {
			System.out.print("No platfrom found");
			LOGGER.error("No platfrom found with name " + OSDetails);
		}
		}

		switchToRemoteBrowser(browser);

		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + hubUrl),
					desiredCapabilities);
		} catch (MalformedURLException e) {
			LOGGER.error(e.getMessage());
		}

		return driver;

	}

	public void switchToRemoteBrowser(String browser) {
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
			LOGGER.error("No Browser found with name " + browser);
		}
		}
	}

	public WebDriver switchToLocalBrowser(WebDriver driver, String browser) {
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

		return driver;
	}
}
