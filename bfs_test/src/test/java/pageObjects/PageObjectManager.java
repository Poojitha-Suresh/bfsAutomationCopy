package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public RegistrationPage registrationPage;
	public LoginPage loginPage;
	public SlotBookingPage slotBookingPage;

	
	public RegistrationPage getRegistrationPage() {
		registrationPage = new  RegistrationPage(driver);
		return registrationPage;
	}
	
	public LoginPage getLoginPage() {
		loginPage = new  LoginPage(driver);
		return loginPage;
	}
	
	public SlotBookingPage getSlotBookingPage() {
		slotBookingPage = new  SlotBookingPage(driver);
		return slotBookingPage;
	}
	
}

