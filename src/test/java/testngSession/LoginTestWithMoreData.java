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

public class LoginTestWithMoreData {

WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {                 //will return a two dimensional object array
			
			{"ganesh","karthick","ganesh@gmail.com","012365" ,"test123"},
			{"viju", "mk" ,"karthick@gmail.com","78945", "2"},
			{"babu","baloo","babu@123gmail.com", "52146", "245"},
			{"ammu", "py","ammu@gmail.com", "3569874" , "1254"}
	
	
		};
	}
		
	@Test(dataProvider = "getLoginData")
	public void loginNegativeTest(String firstname, String lastname, String email, String phonenum, String pwd) {
		boolean doRegister = doRegister(firstname, lastname, email, phonenum, pwd);
		//Assert.assertEquals(true, doLogin);
		Assert.assertTrue(doRegister);
		
		
	}
	
	public boolean doRegister(String firstname, String lastname, String email, String phonenum, String pwd) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phonenum);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='checkbox']")).clear();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		String text = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(text);
		
		if(text.contains("Your Account Has Been Created!")) {
			return true;
		}
			else {
				return false;
			}
		}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}


	



