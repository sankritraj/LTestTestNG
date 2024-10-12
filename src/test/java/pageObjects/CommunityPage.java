package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class CommunityPage {
	WebDriver driver;
	Waits seleniumWait;

	public CommunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);
	}

	@FindBy(xpath = "//*[normalize-space()='Welcome To The LambdaTest Community']")
	WebElement text_Community;

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void waitForCommuityPage() {
		seleniumWait.waitForElementVisible(text_Community);
	}
}
