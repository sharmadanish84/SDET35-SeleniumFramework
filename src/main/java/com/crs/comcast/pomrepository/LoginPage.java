package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	this.driver=driver;	
	}
	@FindBy(name = "user_name")
	private WebElement userName;
	@FindBy(name = "user_password")
	private WebElement passWord;
	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassWord() {
		return passWord;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void LoginToApp(String username, String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		submitButton.click();
	}
	
}
