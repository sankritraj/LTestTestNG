package utilities;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	WebDriver driver;
	public Logger LOGGER = Logger.getLogger(Waits.class);

	public Waits(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean waitForElementVisibleByElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}

	public void visibilityOfAllElements(List<WebElement> multipleElements) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> allVisibleElements = wait.until(ExpectedConditions.visibilityOfAllElements(multipleElements));
		LOGGER.info("Total Size is "+allVisibleElements.size());
		for (WebElement elementCheck : allVisibleElements) {
			LOGGER.info(elementCheck.getText() + " is visible");

		}

	}
}
