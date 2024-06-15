package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Amit Kulkarni
 * BroweserUtil is having multiple generic methods to handle the various browser actions
 */


public class BrowserUtil {
	
	private WebDriver driver;
	
	/**
	 * This method is used to launch the browser on basis of giver browserName
	 * @param browserName
	 * @return this returns the driver instance
	 */
	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser name : " + browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please pass the right browser......");
			throw new AutomationException("INVALID BROWSER" +browserName);
		}
		
		return driver;
	}
	
	/**
	 * this method is used to launch the URL
	 * @param url
	 */
	
	public void launchURL(String url) {
		if(url==null) {
			System.out.println("URL IS NULL");
			throw new AutomationException("NULL URL");
		}
		
		if(url.indexOf("http")==0) {
			driver.get(url);
		}
		else {
			throw new AutomationException("HTTP is missing");
		}
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String getPageURL() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public boolean getPageSource(String value) {
		String pageSource = driver.getPageSource();
		if(pageSource.contains(value)) {
			return true;
		}
		return false;
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	
	

}
