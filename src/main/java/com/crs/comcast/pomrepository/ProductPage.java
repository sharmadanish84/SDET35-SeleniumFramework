package com.crs.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		this.driver=driver;	
	}
		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createOrgimg;
		@FindBy(name = "productname")
		private WebElement proNameEdt;
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
		public WebElement getProName() {
			return proNameEdt;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		public WebElement getCreateProductimg() {
			return createOrgimg;
		}
		public void createProduct(String prodName) {
			proNameEdt.sendKeys(prodName);
			saveButton.click();
		}
		

}
	

