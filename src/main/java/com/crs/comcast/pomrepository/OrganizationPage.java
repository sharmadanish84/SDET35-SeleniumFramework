package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
public OrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	this.driver=driver;		
}
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createOrgimg;
public WebElement getCreateOrgimg() {
	return createOrgimg;
}

}
