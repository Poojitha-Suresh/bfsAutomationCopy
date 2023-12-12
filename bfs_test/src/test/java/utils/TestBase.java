package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", 
					"E:\\BFS Test Automation\\ChromeDriver\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
		return driver;
	}

}