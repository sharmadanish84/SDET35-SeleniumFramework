package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.opera.OperaDriver;

public class HardCoreDataVtigerTest {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.clear();
		userName.sendKeys("admin");
		WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
		passWord.clear();
		passWord.sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

}
