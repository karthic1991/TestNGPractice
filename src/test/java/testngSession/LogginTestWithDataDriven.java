package testngSession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogginTestWithDataDriven {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@DataProvider
	public Object[][] getNegativeLoginData() {
		return new Object[][] {                 //will return a two dimensional object array
			
			{"ganesh@gmail.com","test123"},
			{"karthick@gmail.com", "2"},
			{"babu", "245"},
			{"ammu@gmail.com", "2235"}
			
			
		};
	}
	@Test(dataProvider = "getNegativeLoginData")
	public void loginNegativeTest(String username, String password) {
		boolean doLogin = doLogin(username,password);
		//Assert.assertEquals(true, doLogin);
		Assert.assertTrue(doLogin);
		
		
	}
	
	public boolean doLogin(String username, String password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String errText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println(errText);
		if(errText.contains("Warning: No match for E-Mail Address and/or Password.")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
