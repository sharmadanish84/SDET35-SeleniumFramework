package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriver_Utility;

public class CreateCampaignPage extends WebDriver_Utility {
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver=driver;	
	}
	@FindBy(name = "campaignname")
	private WebElement campNameEdt;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement proAddButton;
	
	@FindBy(id = "search_txt")
	private WebElement childSearchBox;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement childSearchNow;
	
	@FindBy(xpath = "//td/a[@href='javascript:window.close();']")
	private WebElement proclick;
	
	public WebElement getProAddButton() {
		return proAddButton;
	}

	public WebElement getChildSearchBox() {
		return childSearchBox;
	}

	public WebElement getChildSearchNow() {
		return childSearchNow;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampNameEdt() {
		return campNameEdt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createCampaign(String ccampName) {
		campNameEdt.sendKeys(ccampName);
		saveButton.click();
	}
	
	public void searchProduct(String camName,String proName) {
		campNameEdt.sendKeys(camName);
		proAddButton.click();
		switchToWindow(driver, "Products&action");
		childSearchBox.sendKeys(proName);
		childSearchNow.click();
		proclick.click();
		switchToWindow(driver, "Campaigns&action");
		saveButton.click();
	}
}
