package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class TestingwhizIntegrations {
	WebDriver driver;
	Waits seleniumWait;
	
	public TestingwhizIntegrations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);
	}
	
	@FindBy(xpath = "//a[@href='https://www.testing-whiz.com/']")
	WebElement link_TestingWhiz;
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void waitForTestingWhizLink()
	{
		seleniumWait.waitForElementVisible(link_TestingWhiz);
	}
}
