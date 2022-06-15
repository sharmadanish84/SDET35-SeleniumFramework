package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerLoginComDataTest {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./data/commondata.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String Browser = pro.getProperty("browser");
	String Url = pro.getProperty("url");
	String Username = pro.getProperty("un");
	String Password = pro.getProperty("pwd");
	
	WebDriver driver;
	if(Browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	
	
	driver.get(Url);
    driver.findElement(By.name("user_name")).sendKeys(Username);
    driver.findElement(By.name("user_password")).sendKeys(Password);
    driver.findElement(By.id("submitButton")).click();
	}

}
