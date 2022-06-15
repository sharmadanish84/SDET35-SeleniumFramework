package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.Excel_Utility;

public class DataProviderFromExcelTest {
	@Test(dataProvider = "bookTicketDataProvider")
	public void bookticket(String src,String dest,String ticket) {
		System.out.println("Source is " + src + " Destination is " + dest + " number of passengers are " + ticket);
	}
	@DataProvider
	public Object[][] bookTicketDataProvider() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
	    String src1 = elib.getDataFromExcel("Sheet2", 1, 0);
	   String dest1 = elib.getDataFromExcel("Sheet2", 1, 1);
	    String tick1 = elib.getDataFromExcel("Sheet2", 1, 2);
	    
	    String src2  =elib.getDataFromExcel("Sheet2", 2, 0);
	    String dest2=elib.getDataFromExcel("Sheet2", 2, 1);
	    String tick2=elib.getDataFromExcel("Sheet2", 2, 2);
	    
	    String src3=elib.getDataFromExcel("Sheet2", 3, 0);
	    String dest3= elib.getDataFromExcel("Sheet2", 3, 1);
	    String tick3= elib.getDataFromExcel("Sheet2", 3, 2);
		
		Object[][] objarr=new Object[3][3];
		objarr[0][0]=src1;
		objarr[0][1]=dest1;
		objarr[0][2]=tick1;
		
		
		objarr[1][0]=src2;
		objarr[1][1]=dest2;
		objarr[1][2]=tick2;
		
		
		objarr[2][0]=src3;
		objarr[2][1]=dest3;
		objarr[2][2]=tick3;
		return objarr;
		
		
		
	}
}
