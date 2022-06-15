package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTimeLoginDataDrivenTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("./data/CommonData1.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String Browser1 = pro.getProperty("browser1");
	String Url1 = pro.getProperty("url1");
	String Username1 = pro.getProperty("un1");
	String Password1 = pro.getProperty("pwd1");
	WebDriver driver=new ChromeDriver();
	driver.get(Url1);
	driver.findElement(By.id("username")).sendKeys(Username1);
	driver.findElement(By.name("pwd")).sendKeys(Password1);
	driver.findElement(By.id("loginButton")).click();
} 
}
