package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
WebDriver driver;
public CreateProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	this.driver=driver;	
}
@FindBy(name = "productname")
private WebElement productNameEdt;
@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveButton;
public WebDriver getDriver() {
	return driver;
}
public WebElement getProductNameEdt() {
	return productNameEdt;
}
public WebElement getSaveButton() {
	return saveButton;
}
public void createProduct(String proName)
{
	productNameEdt.sendKeys(proName);
	saveButton.click();
}
}
