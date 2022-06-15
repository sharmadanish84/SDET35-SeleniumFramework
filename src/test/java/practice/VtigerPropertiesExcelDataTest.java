package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerPropertiesExcelDataTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./data/commondata.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String Browser = pro.getProperty("browser");
	String Url = pro.getProperty("url");
	String Username = pro.getProperty("un");
	String Password = pro.getProperty("pwd");
	
	
	Random ran = new Random();
	int ranDomNum = ran.nextInt(10000);
	
	FileInputStream fis_1 = new FileInputStream("Book 1.xlsx");
	Workbook wb = WorkbookFactory.create(fis_1);
	Sheet sheet = wb.getSheet("Sheet1");
	Row row = sheet.getRow(1);
	String orgName = row.getCell(1).getStringCellValue() + ranDomNum;
	
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
	 
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	String actualText = driver.findElement(By.className("dvHeaderText")).getText();
	if (actualText.contains(orgName)) {
		System.out.println("pass: organization name is succesfully created");
	} else {
       System.out.println("fail: organization name is not created");
	}
	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
}
}
