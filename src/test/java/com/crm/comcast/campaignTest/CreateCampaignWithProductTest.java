package com.crm.comcast.campaignTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.CampaignInfoPage;
import com.crs.comcast.pomrepository.CampaignPage;
import com.crs.comcast.pomrepository.CreateCampaignPage;
import com.crs.comcast.pomrepository.HomePage;
import com.crs.comcast.pomrepository.ProductPage;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class CreateCampaignWithProductTest extends BaseClass{
	
	@Test(groups = "smoketest")
 public void createCampProduct() throws Throwable {
		int ranDomNum=javalib.getRandomNum();
		String campName = excellib.getDataFromExcel("Sheet1", 1, 3) + ranDomNum;
		String proName = excellib.getDataFromExcel("Sheet1", 1, 4) + ranDomNum;
		
		HomePage hp = new HomePage(driver);
        hp.getProlink().click();
        
        ProductPage pp = new ProductPage(driver);
        pp.getCreateProductimg().click();
        pp.createProduct(proName);
        
        hp.moveToCampaign(campName);
        CampaignPage campage = new CampaignPage(driver);
		campage.getCreateOrgimg().click();
		
		CreateCampaignPage createCampPage = new CreateCampaignPage(driver);
		createCampPage.searchProduct(campName, proName);
		
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
