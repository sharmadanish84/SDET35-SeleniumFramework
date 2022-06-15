package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver=driver;	
	}
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createCon(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveButton.click();
	}
}
