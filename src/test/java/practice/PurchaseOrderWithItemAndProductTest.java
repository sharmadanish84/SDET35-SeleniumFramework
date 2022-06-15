package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.Excel_Utility;
import genericUtilities.File_Utility;
import genericUtilities.Java_utility;
import genericUtilities.WebDriver_Utility;

public class PurchaseOrderWithItemAndProductTest {

	public static void main(String[] args) throws Throwable {
		    File_Utility flib = new File_Utility();
			Java_utility jlib = new Java_utility();
			Excel_Utility elib = new Excel_Utility();
			WebDriver_Utility wlib = new WebDriver_Utility();
			
			String browser = flib.propertyKeyAndValue("browser");
			String Url = flib.propertyKeyAndValue("url");
			String Username = flib.propertyKeyAndValue("un");
			String Password = flib.propertyKeyAndValue("pwd");
			
			int ranDomNum=jlib.getRandomNum();
			
			String vendorName = elib.getDataFromExcel("Sheet1", 1, 5) + ranDomNum;
			String subject = elib.getDataFromExcel("Sheet1", 1, 6) + ranDomNum;
			String bAddress = elib.getDataFromExcel("Sheet1", 1, 7) + ranDomNum;
			String proName = elib.getDataFromExcel("Sheet1", 1, 4) + ranDomNum;
			
			WebDriver driver=new ChromeDriver();
			wlib.waitForElementInDOM(driver);
			wlib.maximizeTheWindow(driver);
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	        Actions action = new Actions(driver);
	        action.moveToElement(element).perform();
	        driver.findElement(By.linkText("Vendors")).click();
	        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	        driver.findElement(By.name("vendorname")).sendKeys(vendorName);
	        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	        WebElement element1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	        action.moveToElement(element1).perform();
	        driver.findElement(By.linkText("Purchase Order")).click();
	        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	        driver.findElement(By.name("subject")).sendKeys(subject);
	       
	        driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	        
	        Set<String> set1 = driver.getWindowHandles();
	        Iterator<String> it1 = set1.iterator();
	        
	        while (it1.hasNext()) {
				String Cid = it1.next();
				driver.switchTo().window(Cid);
				String title1 = driver.getTitle();
				if (title1.contains("Vendor&action")) {
					break;
				}
				
			}
	        driver.findElement(By.id("search_txt")).sendKeys(vendorName);
	        
	        driver.findElement(By.name("search")).click();
	        driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
	        
	        Set<String> set2 = driver.getWindowHandles();
	        Iterator<String> it2 = set2.iterator();
	        
	        while (it2.hasNext()) {
				String Cid = it2.next();
				driver.switchTo().window(Cid);
				String title2 = driver.getTitle();
				if (title2.contains("PurchaseOrder&action")) {
					break;
				}
				
			}
	        driver.findElement(By.xpath("//td/textarea[@name='bill_street']")).sendKeys(bAddress);
	        driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
	        
	        Set<String> set3 = driver.getWindowHandles();
	        Iterator<String> it3 = set3.iterator();
	        
	        while (it3.hasNext()) {
				String Cid = it3.next();
				driver.switchTo().window(Cid);
				String title3 = driver.getTitle();
				if (title3.contains("Products&action")) {
					break;
				}
				
			}
	        driver.findElement(By.id("search_txt")).sendKeys(proName);
	        
	        driver.findElement(By.name("search")).click();
	        driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
	        
	        Set<String> set4 = driver.getWindowHandles();
	        Iterator<String> it4 = set4.iterator();
	        
	        while (it4.hasNext()) {
				String Cid = it4.next();
				driver.switchTo().window(Cid);
				String title4 = driver.getTitle();
				if (title4.contains("PurchaseOrder&action")) {
					break;
				}
				
			}
	        
	        
	        

	}

}
