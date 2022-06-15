package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver=driver;	
	}
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveButton.click();
	}
}
