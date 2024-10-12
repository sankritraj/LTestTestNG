package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CustomKeywords;
import utilities.Waits;

public class Integrations {
	WebDriver driver;
	Waits seleniumWait;
	private CustomKeywords customKeywords;
	
	public Integrations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);
	}
	
	@FindBy(xpath = "//div[@id='codeless_row']//h2[@class='text-size-24 font-semibold m-2']")
	WebElement text_CodelessAutomation;
	
	@FindBy(xpath = "//a[normalize-space()='Integrate Testing Whiz with LambdaTest']")
	WebElement link_TestingWhiz;
	
	public void clickOnTestingWhiz() {
		customKeywords= new CustomKeywords(driver);
		customKeywords.scrollToViewElement(text_CodelessAutomation, driver);
		seleniumWait.waitForElementClickable(link_TestingWhiz);
		customKeywords.customCick(link_TestingWhiz, driver);
		

	}
	
	

}
