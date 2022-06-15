package com.crm.comcast.contactTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.ContactPage;
import com.crs.comcast.pomrepository.CreateContactPage;
import com.crs.comcast.pomrepository.HomePage;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class CreateContactWithoutMandatTest extends BaseClass {
	@Test
	public void createContact () throws Throwable {
	
	HomePage hp = new HomePage(driver);
	hp.getConlink().click();
	
	ContactPage cp = new ContactPage(driver);
	cp.getCreateConimg().click();
	
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.getSaveButton().click();
	drivlib.swithToAlertWindowAndAccpect(driver, "Last Name cannot be empty");
}
}
