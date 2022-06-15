package practice;



import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
@Test
	public void createContact() {
		System.out.println("test1");
		System.out.println("test2");
		Assert.assertEquals("a", "b");

		System.out.println("test3");
		System.out.println("test4");
		
	}
@Test
  public void modify() {
	  System.out.println("test5");
	  System.out.println("test6");
	  System.out.println("test7");
  }
}
