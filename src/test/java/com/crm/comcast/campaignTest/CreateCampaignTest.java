package com.crm.comcast.campaignTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.CampaignInfoPage;
import com.crs.comcast.pomrepository.CampaignPage;
import com.crs.comcast.pomrepository.CreateCampaignPage;
import com.crs.comcast.pomrepository.HomePage;
import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class CreateCampaignTest extends BaseClass {
	
	@Test(groups = "smoketest")
	 public void createCampaign() throws Throwable {
		
		int ranDomNum=javalib.getRandomNum();
			String campName = excellib.getDataFromExcel("Sheet1", 1, 3) + ranDomNum;
			
			HomePage hp = new HomePage(driver);
			hp.moveToCampaign(campName);
			
			CampaignPage campage = new CampaignPage(driver);
			campage.getCreateOrgimg().click();
			
			CreateCampaignPage createCampPage = new CreateCampaignPage(driver);
			createCampPage.createCampaign(campName);
			
			CampaignInfoPage campInfoPage = new CampaignInfoPage(driver);
			drivlib.waitForElement(driver, campInfoPage.getVerifiedMsg());
			String actualMsg = campInfoPage.getVerifiedMsg().getText();
			
			if(actualMsg.contains(campName))
			{
				System.out.println("campaign is created");
			}
			else {
				System.out.println("campaign is not created");
			}
	        
	 }
}
