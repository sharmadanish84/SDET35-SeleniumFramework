package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {
@Test
	public void add() {
		System.out.println("1");
		System.out.println("2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("a", "b");
		System.out.println("3");
		System.out.println("4");
		sa.assertAll();
	}
@Test
public void multi() {
	System.out.println("5");
	System.out.println("6");
}
}
