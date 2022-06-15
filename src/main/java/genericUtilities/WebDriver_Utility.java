package genericUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	/**
	 * this method will always wait for Element in DOM document & release the control if element available. It is a implicit wait
	 * @author Danish
	 */

	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyTimeout,TimeUnit.SECONDS);
		
	}
	
	/**
	 * this method is used to maximize the window
	 * @author Danish
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        
        while (it.hasNext()) {
			String Cid = it.next();
			driver.switchTo().window(Cid);
			String title = driver.getTitle();
			if (title.contains(partialWindowTitle)) {
				break;
				
				/**
				 * this method is used for switching the window control 
				 * @author Danish
				 */
			}
			
		}
        
	}
	public void moveElement(WebDriver driver, WebElement ele)
	{
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	/**
	 * this method is used to move the cursor to the required element
	 * @author Danish
	 */
	public void waitForPage(WebDriver driver,String partialPageUrl)
	{
		WebDriverWait wait = new WebDriverWait(driver, IConstant.expliclitytimeout);
		wait.until(ExpectedConditions.urlContains(partialPageUrl));
	}
	
	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, IConstant.expliclitytimeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) 
	{
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		alt.accept();
	}
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().equals(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		 alt.dismiss();
	}

	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByValue(text);
	}

	
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
		    	   }
	   }
	   
	   public void switchToFrame(WebDriver driver , int index) {
			driver.switchTo().frame(index);
		}
	   


}
