package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckBoxDemoPage;
import pageObjects.JavascriptAlertPage;
import pageObjects.SeleniumPlayground;
import testBase.BaseClass;
import utilities.Waits;

public class ParllelExecutionsTestNG extends BaseClass {
	private SeleniumPlayground seleniumPlayground;
	private CheckBoxDemoPage checkBoxDemoPage;
	private JavascriptAlertPage javascriptAlertPage;
	Waits seleniumWait;

	@Test(description = "Test Scenario 1", timeOut = 20000)
	public void Scenario1() {
		seleniumPlayground = new SeleniumPlayground(driver);
		checkBoxDemoPage = new CheckBoxDemoPage(driver);
		SoftAssert softAssert = new SoftAssert();
		seleniumPlayground.allElementsVisiblity();
		String currentTitle = driver.getTitle();
		String expectedTitle = "LambdaTest";
		System.out.print("Current url is " + currentTitle);
		softAssert.assertEquals(currentTitle, expectedTitle);
		softAssert.assertAll();
	}

	@Test(description = "Test Scenario 2")
	public void Scenario2() {
		seleniumPlayground = new SeleniumPlayground(driver);
		checkBoxDemoPage = new CheckBoxDemoPage(driver);
		SoftAssert softAssert = new SoftAssert();
		seleniumPlayground.click_CheckBoxDemo();
		checkBoxDemoPage.click_SingleChecbox();
		softAssert.assertEquals(checkBoxDemoPage.getAttitbuteValue(), true);
		checkBoxDemoPage.click_SingleChecbox();
		softAssert.assertEquals(checkBoxDemoPage.getAttitbuteValue(), false);
		LOGGER.info("End of Scenario 2 testing");
		softAssert.assertAll();

	}
	@Test(description = "Test Scenario 3")
	public void Scenario3() {
		seleniumPlayground = new SeleniumPlayground(driver);
		checkBoxDemoPage = new CheckBoxDemoPage(driver);
		javascriptAlertPage = new JavascriptAlertPage(driver);
		seleniumPlayground.click_JavascriptAlert();
		javascriptAlertPage.click_JavascriptAlterClickMe();
		String actual= javascriptAlertPage.getJavaScriptAleratMessage();
		LOGGER.info("Alert message is "+actual);
		String expected="I am an alert box!";
		Assert.assertEquals(actual, expected);
		driver.switchTo().alert().dismiss();

	}

}
