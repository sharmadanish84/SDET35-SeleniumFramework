package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.ContactInfoPage;
import com.crs.comcast.pomrepository.ContactPage;
import com.crs.comcast.pomrepository.CreateContactPage;
import com.crs.comcast.pomrepository.HomePage;
import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class CreateContactTest extends BaseClass{
	
	@Test(groups = "regressiontest")
public void createContact () throws Throwable {
		int ranDomNum=javalib.getRandomNum();
	String lastName = excellib.getDataFromExcel("Sheet1", 1, 1) + ranDomNum;
	
	HomePage hp = new HomePage(driver);
	hp.getConlink().click();
	
	ContactPage cp = new ContactPage(driver);
	cp.getCreateConimg().click();
	
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.createCon(lastName);
	
	ContactInfoPage conInfoPage = new ContactInfoPage(driver);
	String actualConName = conInfoPage.actualConPage();
	Assert.assertEquals(actualConName.contains(lastName), true);
	/*drivlib.waitForElement(driver, conInfoPage.getVerifiedMsg());
	String actualMsg = conInfoPage.getVerifiedMsg().getText();
	if(actualMsg.contains(lastName))
	{
		System.out.println("contact is created");
	}
	else {
		System.out.println("contact is not created");
	}*/
	
	
}
}
