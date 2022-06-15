package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crs.comcast.pomrepository.HomePage;
import com.crs.comcast.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public File_Utility filelib=new File_Utility();
public Java_utility javalib = new Java_utility();
public Excel_Utility excellib = new Excel_Utility();
public WebDriver_Utility drivlib = new WebDriver_Utility();
public WebDriver driver;
public static WebDriver sdriver;

@BeforeSuite(groups= {"smoketest","regressiontest"})
 public void bs() 
 {
	 System.out.println("database connection");
 }
@BeforeTest(groups= {"smoketest","regressiontest"})
 public void bt() {
	 System.out.println("execute script in parallel mode");
 }
@Parameters("Browser")
@BeforeClass(groups= {"smoketest","regressiontest"})
 public void bc() throws Throwable{
	String Browser = filelib.propertyKeyAndValue("browser");
	//Reporter.log(Browser, true);
	 if (Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	 else if (Browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	 else {
		driver=new ChromeDriver();
		
	}
	 driver.manage().window().maximize();
	 drivlib.waitForElementInDOM(driver);
	 String url = filelib.propertyKeyAndValue("url");
	 driver.get(url);
	 sdriver=driver;
	 
 }
@BeforeMethod(groups= {"smoketest","regressiontest"})
 public void bm() throws Throwable {
	 String username = filelib.propertyKeyAndValue("un");
	 String password = filelib.propertyKeyAndValue("pwd");
	 LoginPage loginpage = new LoginPage(driver);
	 loginpage.LoginToApp(username, password);
	 
 }
@AfterMethod(groups= {"smoketest","regressiontest"})
 public void am() {
	 HomePage homepage = new HomePage(driver);
	 homepage.logout();
 }
@AfterClass(groups= {"smoketest","regressiontest"})
 public void ac() {
	 driver.quit();
 }
@AfterTest(groups= {"smoketest","regressiontest"})
 public void at() {
	 System.out.println("parallel execution is completed");
	 
 }
@AfterSuite(groups= {"smoketest","regressiontest"})
 public void as() {
	 System.out.println("connection with database removed");
 }
}
