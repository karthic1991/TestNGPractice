package testngSession;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {


	@Test(priority = 1)
	public void searchTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		System.out.println(flag);
		Assert.assertEquals(flag, true);

	}

	@Test
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
		
	}
    @Test(priority = 2)
    public void logoTest() {
    	boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
    	Assert.assertTrue(flag);
    }

}