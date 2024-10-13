package testCases;

import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.BaseClass;
import utilities.TestContext;

public class SeleniumAdvanced extends BaseClass {
	TestContext testContext;

	@Test(description = "Selenium Advance Testing Scenario")
	public void SeleniumAdvancedScen() {
		testContext = new TestContext();
		testContext.initlizePageObjects(driver);
		SoftAssert softAssert = new SoftAssert();

		testContext.getlambdaTestPage().allElementsVisiblity();
		String parentWindow = driver.getWindowHandle();
		LOGGER.info("Parent window is " + parentWindow);
		testContext.getlambdaTestPage().clickOnExploreAllIntegrations();

		testContext.getCustomKeywords().switchToWindow(driver);
		String expectedUrl = "https://www.lambdatest.com/integrations";
		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, expectedUrl);

		testContext.getIntegrations().clickOnTestingWhiz();
		testContext.getTestingwhizIntegrations().waitForTestingWhizLink();
		String expectdTitle = "TestingWhiz Integration With LambdaTest";
		String actualTitle = testContext.getTestingwhizIntegrations().getPageTitle();
		softAssert.assertEquals(actualTitle, expectdTitle);
		driver.close();

		testContext.getCustomKeywords().switchBackToMainWindow(driver, parentWindow);
		Set<String> allWindows = driver.getWindowHandles();
		LOGGER.info("Current Window count is " + allWindows.size());
		driver.navigate().to("https://www.lambdatest.com/blog");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		testContext.getBlogPage().clickCommunityButton();
		testContext.getCommunityPage().waitForCommuityPage();
		expectdTitle = "https://community.lambdatest.com/";
		actualTitle = testContext.getCommunityPage().getPageUrl();
		softAssert.assertEquals(actualTitle, expectdTitle);
		driver.close();

		softAssert.assertAll();
	}

}
