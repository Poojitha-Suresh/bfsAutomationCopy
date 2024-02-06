package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Admin\\Desktop\\bfs_automation\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		return driver;
	}

}
