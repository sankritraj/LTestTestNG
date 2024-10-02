package pageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class SeleniumPlayground {
	WebDriver driver;
	Waits seleniumWait;
	public SeleniumPlayground(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		seleniumWait= new Waits(this.driver);
		
	}
	
	@FindBy(xpath = "//a[normalize-space()='Simple Form Demo']")
	WebElement button_simpleFormData;
	
	@FindBy(xpath = "//a[normalize-space()='Checkbox Demo']")
	WebElement button_checkBoxDemo;
	
	@FindBy(xpath = "//a[normalize-space()='Javascript Alerts']")
	WebElement button_javascriptAlert;
	
	
	@FindAll({
	@FindBy(xpath="//*//*[@class='pt-10']")
	})
	List<WebElement> multipleElements;
	
	@FindBy(id = "user-message")
	WebElement text_SingleInputField;
	
	@FindBy(xpath = "//a[normalize-space()='Drag & Drop Sliders']")
	WebElement button_DragAndDrop;
	
	@FindBy(css="#showInput")
	WebElement button_ShowInput;

	@FindBy(xpath="//p[@id='message']")
	WebElement text_Message;
	
	@FindBy(xpath="//a[normalize-space()='Input Form Submit']")
	WebElement button_InputFormSubmit;
	
	public void click_SimpleFormData()
	{
		seleniumWait.waitForElementVisible(button_simpleFormData);
		button_simpleFormData.click();
	}
	
	public void click_CheckBoxDemo()
	{
		seleniumWait.waitForElementVisible(button_checkBoxDemo);
		button_checkBoxDemo.click();
	}
	
	public void click_JavascriptAlert()
	{
		seleniumWait.waitForElementVisible(button_javascriptAlert);
		button_javascriptAlert.click();
	}
	
	public void click_InputFormData()
	{
		seleniumWait.waitForElementVisible(button_InputFormSubmit);
		button_InputFormSubmit.click();
	}
	
	public void setText_SingleInputField(String message)
	{
		seleniumWait.waitForElementVisible(text_SingleInputField);
		text_SingleInputField.clear();
		text_SingleInputField.sendKeys(message);
	}
	
	public String getTextMessage()
	{
		seleniumWait.waitForElementVisible(text_Message);
		String textMessage= text_Message.getText();
		return textMessage;
	}
	
	public void click_GetCheckedValue()
	{
		button_ShowInput.click();
	}
	
	public void click_dragAndDrop()
	{
		seleniumWait.waitForElementVisible(button_DragAndDrop);
		button_DragAndDrop.click();
	}
	
	public void allElementsVisiblity()
	{
		seleniumWait.visibilityOfAllElements(multipleElements);
	}
	
}
