package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutDDTTest {

	@Test(dataProvider = "bookTicketDataProvider")
	public void bookticket(String src,String dest,int ticket) {
		System.out.println("Source is " + src + " Destination is " + dest + " number of passengers are " + ticket);
	}
	@DataProvider
	public Object[][] bookTicketDataProvider()
	{
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="London";
		objarr[0][1]="Paris";
		objarr[0][2]=10;
		
		objarr[1][0]="New York";
		objarr[1][1]="Sydney";
		objarr[1][2]=30;
		
		objarr[2][0]="Amsterdam";
		objarr[2][1]="Toronto";
		objarr[2][2]=20;
		return objarr;
		
	}
}
