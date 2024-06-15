package SeleniumSessions;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		String actTitle = driver.getTitle();
		System.out.println("Title is:" +actTitle);
		
	}

}
