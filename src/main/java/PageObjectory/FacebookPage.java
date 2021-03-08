package PageObjectory;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class FacebookPage {
	
    WebDriver driver;
    
	public FacebookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailOrPhoneNumber;
	
	@FindBy(xpath = "//div[@id='passContainer']")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement LoginButton;
	
	public void EmailOrPhoneNumber(String value){
		EmailOrPhoneNumber.sendKeys(value);
	}
	
	public WebElement Password(){
	    return Password;
	}
	
	public void LoginButtons(){
		LoginButton.click();
	}

	
}
