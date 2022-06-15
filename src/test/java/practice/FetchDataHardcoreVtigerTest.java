package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataHardcoreVtigerTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		WebElement userName = driver.findElement(By.name("user_name"));
		userName.clear();
		userName.sendKeys("admin");
		WebElement passWord = driver.findElement(By.name("user_password"));
		passWord.clear();
		passWord.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TestYantra");
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(3000);
		String alertPopUpText = driver.switchTo().alert().getText();
		System.out.println(alertPopUpText);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//input[@title='Cancel [Alt+X]'])[1]")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&parenttab=Marketing&action=DetailView&record=2']")).click();
        driver.quit();
	}

}
