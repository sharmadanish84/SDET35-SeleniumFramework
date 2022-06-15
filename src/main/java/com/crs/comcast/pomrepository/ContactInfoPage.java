package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriver_Utility;

public class ContactInfoPage extends WebDriver_Utility {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver=driver;	
	}
	@FindBy(className = "dvHeaderText")
	private WebElement VerifiedMsg;
	@FindBy(name = "Delete")
	private WebElement deleteContact;
	@FindBy(name = "Edit")
	private WebElement editContact;
	@FindBy(name = "Duplicate")
	private WebElement duplicateContact;
	@FindBy(name = "search_text")
	private WebElement searchBox;
	@FindBy(name = "submit")
	private WebElement submitSearchBox;
	@FindBy(id="bas_searchfield")
	private WebElement selectDropDown;
	public WebElement getSelectDropDown() {
		return selectDropDown;
	}
	public WebElement getSubmitSearchBox() {
		return submitSearchBox;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getDuplicateContact() {
		return duplicateContact;
	}
	public WebElement getDeleteContact() {
		return deleteContact;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getEditContact() {
		return editContact;
	}
	public WebElement getVerifiedMsg() {
		return VerifiedMsg;
	}
public void dropDown()
{
	select(selectDropDown, "lastname");

	}
public String actualConPage() {
	return VerifiedMsg.getText();
}
}
