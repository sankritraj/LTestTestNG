package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CustomKeywords;
import utilities.Waits;

public class BlogPage {
	WebDriver driver;
	Waits seleniumWait;
	private CustomKeywords customKeywords;
	public BlogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);
	}

	@FindBy(xpath = "//*[@id='primary-menu']//a[normalize-space()='Community']")
	WebElement buttonCommunity;

	public void clickCommunityButton() {
		customKeywords = new CustomKeywords(driver);
		seleniumWait.fluentWaitForElement(By.xpath("//*[@id='primary-menu']//a[normalize-space()='Community']"));
		customKeywords.customCick(buttonCommunity, driver);
		
	}
}
