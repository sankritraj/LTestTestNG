package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CustomKeywords;
import utilities.Waits;

public class LambdaTestPage {
	WebDriver driver;
	Waits seleniumWait;
	private CustomKeywords customKeywords;

	public LambdaTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);
	}

	@FindAll({ @FindBy(xpath = "//*[contains(@class,'xxl:px-16')]"),
			@FindBy(xpath = "//*[contains(@class,'xlm:text-size-14')]"), @FindBy(xpath = "//*[@role='link']"),
			@FindBy(xpath = "//*[@class='footer-menu']/li"),
			@FindBy(xpath = "//*[@class='header__menu px-2 desktop:w-full']//div/a[contains(@class,'desktop:block')]"),
			@FindBy(xpath = "//*[@class='header__menu px-2 desktop:w-full']//div/button[contains(@class,'desktop:block')]")

	})

	List<WebElement> multipleElements;

	public void allElementsVisiblity() {
		seleniumWait.visibilityOfAllElements(multipleElements);
	}

	@FindBy(xpath = "//*[contains(text(),'Explore all Integrations')]")
	WebElement button_exploreAllIntergrations;

	public void clickOnExploreAllIntegrations() {
		customKeywords= new CustomKeywords(driver);
		customKeywords.scrollToViewElement(button_exploreAllIntergrations, driver);
		seleniumWait.waitForElementClickable(button_exploreAllIntergrations);
		customKeywords.openWindowInNewTabeUsingJavascript(button_exploreAllIntergrations, driver);
		

	}
}
