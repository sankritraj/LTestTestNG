package utilities;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomKeywords {
	WebDriver driver;

	public CustomKeywords(WebDriver driver) {
		this.driver = driver;

	}

	public Logger LOGGER = Logger.getLogger(Waits.class);

	public void scrollToViewElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void customCick(WebElement element, WebDriver driver) {
		try {
			element.click();
			LOGGER.info(element + " is clicked");
		} catch (Exception e) {
			LOGGER.error("Unable to click " + element + " Using Javascript executor now");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			LOGGER.info(element + " is clicked by Javascript executor");
		}

	}

	public void openLinkInNewTabe(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build();
		action.perform();
		LOGGER.info(element + " is clicked by Actions class");
	}

	public void openWindowInNewTabeUsingJavascript(WebElement element, WebDriver driver) {
		String url = element.getAttribute("href");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + url + "','_blank');");
	}

	public void switchToWindow(WebDriver driver) {
		String mainWindowHandle = driver.getWindowHandle();
		LOGGER.info("Parent Window is " + mainWindowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		// Loop through all window handles
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				// Switch to the new window
				driver.switchTo().window(windowHandle);
				LOGGER.info("Switched to Window "+windowHandle);
				break; // Exit the loop once switched
			}
		}
	}
	
	public void switchBackToMainWindow(WebDriver driver, String mainWindowHandle) {
	    // Switch back to the main (parent) window
	    driver.switchTo().window(mainWindowHandle);
	    LOGGER.info("Switched to Window "+mainWindowHandle);
	}
}
