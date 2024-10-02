package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class JavascriptAlertPage {
	WebDriver driver;
	Waits seleniumWait;

	public JavascriptAlertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);

	}

	@FindBy(xpath = "//*[text()='JavaScript Alerts']/button")
	WebElement button_javascriptAlert;

	public void click_JavascriptAlterClickMe() {
		seleniumWait.waitForElementVisible(button_javascriptAlert);
		button_javascriptAlert.click();
	}

	public String getJavaScriptAleratMessage() {

		String message = this.driver.switchTo().alert().getText();
		return message;

	}
}
