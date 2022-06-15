package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriver_Utility;

public class HomePage extends WebDriver_Utility {
WebDriver driver;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	this.driver=driver;	
}
@FindBy(linkText = "Organizations")
private WebElement orglink;
@FindBy(linkText = "Contacts")
private WebElement conlink;
@FindBy(linkText = "Products")
private WebElement prolink;
@FindBy(linkText = "More")
private WebElement moreDropDownMenu;
@FindBy(linkText = "Campaigns")
private WebElement camplink;
@FindBy(linkText = "Purchase Order")
private WebElement purchaselink;
@FindBy(linkText = "Vendors")
private WebElement vendorlink;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;
@FindBy(linkText = "Sign Out")
private WebElement signout;

public WebElement getOrglink() {
	return orglink;
}
public WebElement getMoreDropDownMenu() {
	return moreDropDownMenu;
}
public WebElement getAdminImg() {
	return adminImg;
}
public WebElement getConlink() {
	return conlink;
}
public WebElement getProlink() {
	return prolink;
}
public WebElement getCamplink() {
	return camplink;
}
public WebElement getPurchaselink() {
	return purchaselink;
}
public WebElement getVendorlink() {
	return vendorlink;
}
public WebElement getSignout() {
	return signout;
}
public void logout() {
	moveElement(driver, adminImg);
	signout.click();
}
public void moveToCampaign(String ele) {
	moveElement(driver, moreDropDownMenu);
	camplink.click();
}
public void moveToPurchase() {
	moveElement(driver, moreDropDownMenu);
	purchaselink.click();
}
public void moveToVendor() {
	moveElement(driver, moreDropDownMenu);
	vendorlink.click();
}

}
