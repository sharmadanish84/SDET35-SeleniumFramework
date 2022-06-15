 package com.crm.comcast.organizationTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.CreateOrganizationPage;
import com.crs.comcast.pomrepository.HomePage;
import com.crs.comcast.pomrepository.OrganizationInfoPage;
import com.crs.comcast.pomrepository.OrganizationPage;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class CreateOrgTest extends BaseClass{
	@Test(groups = "smoketest")
	
	public void createOrg() throws Throwable {
		int ranDomNum=javalib.getRandomNum();
		String orgName = excellib.getDataFromExcel("Sheet1", 1, 2) + ranDomNum;
		
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgimg().click();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrg(orgName);
		
		OrganizationInfoPage orgInfoPage = new OrganizationInfoPage(driver);
		String actualOrgName= orgInfoPage.actualOrganizationPage();
		Assert.assertEquals(actualOrgName.contains(orgName), true);
		
	}
	}


