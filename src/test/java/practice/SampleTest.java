package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.LisImpClass.class)
public class SampleTest extends BaseClass
{

	@Test(invocationCount =2 )
	public void createContactTest() 
	{
		System.out.println("contact created");
		Assert.fail();
	}
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() 
	{
		System.out.println("contact modified");
	}
	@Test(dependsOnMethods = "createContactTest")
	public void deleteContactTest() 
	{
		System.out.println("contact deleted");
	}
	
}
