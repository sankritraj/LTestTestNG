package testCases;

import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.BlogPage;
import pageObjects.CommunityPage;
import pageObjects.Integrations;
import pageObjects.LambdaTestPage;
import pageObjects.TestingwhizIntegrations;
import testBase.BaseClass;
import utilities.CustomKeywords;
import utilities.Waits;

public class SeleniumAdvanced extends BaseClass {
	private LambdaTestPage lambdaTestPage;
	private CustomKeywords customKeywords;
	private Integrations integrations;
	private TestingwhizIntegrations testingwhizIntegrations;
	private BlogPage blogPage;
	private CommunityPage communityPage;

	@Test(description = "Test Scenario 1")
	public void SeleniumAdvancedScen() {
		lambdaTestPage = new LambdaTestPage(driver);
		blogPage = new BlogPage(driver);
		integrations = new Integrations(driver);
		testingwhizIntegrations = new TestingwhizIntegrations(driver);
		customKeywords = new CustomKeywords(driver);
		communityPage= new CommunityPage(driver);
		SoftAssert softAssert = new SoftAssert();

		lambdaTestPage.allElementsVisiblity();
		String parentWindow = driver.getWindowHandle();
		LOGGER.info("Parent window is " + parentWindow);
		lambdaTestPage.clickOnExploreAllIntegrations();
		customKeywords.switchToWindow(driver);
		String expectedUrl = "https://www.lambdatest.com/integrations";

		String currentUrl = driver.getCurrentUrl();
		softAssert.assertEquals(currentUrl, expectedUrl);
		integrations.clickOnTestingWhiz();
		testingwhizIntegrations.waitForTestingWhizLink();

		String expectdTitle = "TestingWhiz Integration With LambdaTest";
		String actualTitle = testingwhizIntegrations.getPageTitle();
		softAssert.assertEquals(actualTitle, expectdTitle);
		driver.close();
		customKeywords.switchBackToMainWindow(driver, parentWindow);
		Set<String> allWindows = driver.getWindowHandles();
		LOGGER.info("Current Window count is " + allWindows.size());
		driver.navigate().to("https://www.lambdatest.com/blog");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blogPage.clickCommunityButton();
		communityPage.waitForCommuityPage();
		expectdTitle="https://community.lambdatest.com/";
		actualTitle=communityPage.getPageUrl();
		softAssert.assertEquals(actualTitle, expectdTitle);
		driver.close();
		softAssert.assertAll();
	}

}
