package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	WebDriver driver;
	public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver=driver;	
	}
	@FindBy(className = "dvHeaderText")
	private WebElement VerifiedMsg;
	public WebElement getVerifiedMsg() {
		return VerifiedMsg;
	}
}
