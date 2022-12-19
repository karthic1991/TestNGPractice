package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	WebDriver driver;

	/**
	 * this method is used to initialize the driver on the basis of the browser name
	 * 
	 * @param browser
	 * @return 
	 */
	public WebDriver launchBroswer(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("unspecified browser");
			break;
		}
		return driver;
	}

	public void launchUrl(String url) throws Exception {  //wrapperfunction

		if (url == null) {
			System.out.println("url is null");
			throw new Exception("URISNULL");
		}

		if (url.length() == 0) {
			System.out.println("url is empty");
			throw new Exception("URISEMPTY	");

		}

		driver.get(url);
		;
	}

	public String getPageTitle() {

		String title = driver.getTitle();
		System.out.println(title);

		if (title != null) {
			return title;

		} else {
			System.out.println("getting null title");
			return null;
		}
	}

	public void closeBrowser() {

		if (driver != null) {
			driver.close();
		}
	}

	public void quitBrowser() {

		if (driver != null) {
			driver.quit();
		}
	}

}
