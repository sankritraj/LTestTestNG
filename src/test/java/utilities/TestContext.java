package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.BlogPage;
import pageObjects.CommunityPage;
import pageObjects.Integrations;
import pageObjects.LambdaTestPage;
import pageObjects.TestingwhizIntegrations;



public class TestContext {
	private LambdaTestPage lambdaTestPage;
	private CustomKeywords customKeywords;
	private Integrations integrations;
	private TestingwhizIntegrations testingwhizIntegrations;
	private BlogPage blogPage;
	private CommunityPage communityPage;
	private PropertiesFile propertiesFile;
	public PropertiesFile getPropertiesFile() {
		return propertiesFile;
	}

	public CustomKeywords getCustomKeywords() {
		return customKeywords;
	}

	public Integrations getIntegrations() {
		return integrations;
	}

	public TestingwhizIntegrations getTestingwhizIntegrations() {
		return testingwhizIntegrations;
	}

	public BlogPage getBlogPage() {
		return blogPage;
	}

	public CommunityPage getCommunityPage() {
		return communityPage;
	}

	
	public LambdaTestPage getlambdaTestPage() {
		return lambdaTestPage;
	}

	public void initlizePageObjects(WebDriver driver) {
		lambdaTestPage = new LambdaTestPage(driver);
		blogPage = new BlogPage(driver);
		integrations = new Integrations(driver);
		testingwhizIntegrations = new TestingwhizIntegrations(driver);
		customKeywords = new CustomKeywords(driver);
		communityPage= new CommunityPage(driver);
		customKeywords= new CustomKeywords(driver);
		propertiesFile= new PropertiesFile();

	}

}
