package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Utilities {
	
	WebDriver driver;

	public Utilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void scrollToWebElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void EnterData(WebElement element, String value){
		Actions assigner = new Actions(driver);
		assigner.moveToElement(element);
		assigner.click();
		assigner.sendKeys(value);
		assigner.build().perform();
	}
	
	public void ActionClick(WebElement element){
		Actions assigner = new Actions(driver);
		assigner.moveToElement(element);
		assigner.click();
		assigner.build().perform();
	}
	
	public void javascriptclick(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", element);
	}
	
	
	

}
