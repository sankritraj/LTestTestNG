package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class CheckBoxDemoPage {
	WebDriver driver;
	Waits seleniumWait;

	public CheckBoxDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumWait = new Waits(this.driver);

	}

	@FindBy(xpath = "//*[@id='txtAge']")
	WebElement text_Checkbox;

	@FindBy(xpath = "//input[@id='isAgeSelected']")
	WebElement checkbox_SingleChecboxDemp;

	public void click_SingleChecbox() {
		seleniumWait.waitForElementVisible(checkbox_SingleChecboxDemp);
		checkbox_SingleChecboxDemp.click();
	}

	public boolean getAttitbuteValue() {
		try {
			seleniumWait.waitForElementVisibleByElement(text_Checkbox);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
