package com.crm.comcast.contactTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.ContactInfoPage;
import com.crs.comcast.pomrepository.ContactPage;
import com.crs.comcast.pomrepository.CreateContactPage;
import com.crs.comcast.pomrepository.HomePage;
import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class DeleteContactTest extends BaseClass{
	@Test(groups = "regressiontest")
	public void deleteContact() throws Throwable {
		int ranDomNum=javalib.getRandomNum();
		String lastName = excellib.getDataFromExcel("Sheet1", 1, 1) + ranDomNum;
		
		HomePage hp = new HomePage(driver);
		hp.getConlink().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateConimg().click();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createCon(lastName);
		
		ContactInfoPage conInfoPage = new ContactInfoPage(driver);
		conInfoPage.getDeleteContact().click();
		drivlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
		conInfoPage.dropDown();
		conInfoPage.getSearchBox().sendKeys(lastName);
		conInfoPage.getSubmitSearchBox().click();
		
		
	}
}
