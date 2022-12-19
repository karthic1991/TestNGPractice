package testngSession;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Utils.BrowserUtil;

public class BaseTest {

	WebDriver driver;
    @Parameters({"url", "browser"})  //this comes from testng.xml file
	@BeforeTest // precondition
	public void setup(String url, String browser) {  //and url is given here as runtime parameter
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
    	BrowserUtil br = new BrowserUtil();
    	driver = br.launchBroswer(browser);  //keeping it in a driver asnd passing it to the global WebDriver driver;
    	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	@AfterTest // postcondition
	public void tearDown() {
		driver.quit();

	}
	
}
