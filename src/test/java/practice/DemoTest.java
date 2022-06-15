package practice;

import org.testng.annotations.Test;

import com.crs.comcast.pomrepository.CampaignInfoPage;
import com.crs.comcast.pomrepository.CampaignPage;
import com.crs.comcast.pomrepository.ContactInfoPage;
import com.crs.comcast.pomrepository.ContactPage;
import com.crs.comcast.pomrepository.CreateCampaignPage;
import com.crs.comcast.pomrepository.CreateContactPage;
import com.crs.comcast.pomrepository.CreateOrganizationPage;
import com.crs.comcast.pomrepository.HomePage;
import com.crs.comcast.pomrepository.OrganizationInfoPage;
import com.crs.comcast.pomrepository.OrganizationPage;

import genericUtilities.BaseClass;

public class DemoTest extends BaseClass{
	
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
			drivlib.waitForElement(driver, orgInfoPage.getVerifiedMsg());
			String actualMsg = orgInfoPage.getVerifiedMsg().getText();
			
			if(actualMsg.contains(orgName))
			{
				System.out.println("organization is created");
			}
			else {
				System.out.println("organization is not created");
			}
			
		}
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
			drivlib.waitForElement(driver, conInfoPage.getVerifiedMsg());
			String actualMsg = conInfoPage.getVerifiedMsg().getText();
			if(actualMsg.contains(lastName))
			{
				System.out.println("contact is created");
			}
			else {
				System.out.println("contact is not created");
			}
			
			
		}
		}


