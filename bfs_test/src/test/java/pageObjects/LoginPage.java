package pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.OTPGenerator;

public class LoginPage {

public WebDriver driver;
	
	//class constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	//===================== locators ===================================
	private By brandingLogo_Xpath = By.xpath("//nav[contains(@class,'navbar-transparent')]/div/div/a/div/h6/img");
	private By loginHeaderLabel_Xpath = By.xpath("//div[contains(@class,'form-container')]/p");
	private By countryDialCode_ID = By.id("countryDialCode");
	private By mobileFieldLabel_ID = By.id("mobile-label");
	private By mobileFieldInput_ID = By.id("mobile");
	private By loginButton_Xpath = By.xpath("//button[@type='submit']");
	private By dividerLabel_Xpath = By.xpath("//div[contains(@class, 'justify-content-center')]/span[contains(@class, 'text_gray_light')]");
	private By loginPasswordCTAText_Xpath = By.xpath("//div[contains(@class, 'form-container')]/section/div[contains(@class, 'text-center')]/span");
	private By noAccountText_XPath = By.xpath("//div[contains(@class, 'form-container')]/p/span");
	private By registerNowCTA_XPath = By.xpath("//div[contains(@class, 'form-container')]/p/a");
	private By passwordPageLabel_Xpath = By.xpath("//div[contains(@class,'form-container')]/p[contains(@class,'text-left')]");
	private By emailFieldText_ID = By.id("emailOrMobile-label");
	private By emailFieldInput_ID = By.id("emailOrMobile");
	private By passwordFieldText_ID = By.id("password-label");
	private By passwordFieldInput_ID = By.id("password");
	private By forgotPasswordText_Xpath = By.xpath("//div[@class='text_blue']/p/span");
	private By loginButtonText_Xpath = By.xpath("//span[@class='MuiButton-label']");
	private By loginWithPinButtonText_Xpath = By.xpath("//div[contains(@class,'form-container')]/form/div[contains(@class,'text-center')]/span");
	private By temporaryPinText_Xpath = By.xpath("//div[contains(@class,'form-container')]/form/div[contains(@class,'text-center')]/div");
	private By sendVerificationCodeButton_XPath = By.xpath("//button[@type='submit']");
	private By snackBarErrorMsg_Xpath = By.xpath("//span[@id='client-snackbar']");
	
	//==================================================================

	
	//===================== Common Methods =============================
	public void ensureBrandingLogoDisplayed() throws InterruptedException {
		Thread.sleep(8000);
		WebElement brandingLogo = driver.findElement(brandingLogo_Xpath);
	    Assert.assertTrue(brandingLogo.isDisplayed());
		System.out.println("Test case passed for ensureBrandingLogoDisplayed");
	}
	
	public void ensureLoginHeaderLabel() {
		String loginLabel = driver.findElement(loginHeaderLabel_Xpath).getText();
		Assert.assertEquals(loginLabel, "Log In to Your Account");
		System.out.println("Test case passed for ensureLoginHeaderLabel");
	}
	
	public void ensureDialCodeField() {
		WebElement countryCode = driver.findElement(countryDialCode_ID);
		Select dialCode = new Select(countryCode);
		
		WebElement selectedCode = dialCode.getFirstSelectedOption();
		String selectedCountry = selectedCode.getText();
		//System.out.println(selectedCountry);
		Assert.assertEquals(selectedCountry, "India +91");
		System.out.println("Test case passed for ensureDialCodeField");	
	}
	
	public void ensureMobileFieldLabel() {
		String mobileFieldLabel = driver.findElement(mobileFieldLabel_ID).getText();
		Assert.assertEquals(mobileFieldLabel, "Mobile Number");
		System.out.println("Test case passed for ensureMobileFieldLabel");
	}
	
	public void ensureLoginButtonDisabled() {
		WebElement loginButtonDisabled = driver.findElement(loginButton_Xpath);
		Assert.assertTrue(!loginButtonDisabled.isEnabled());
		System.out.println("Test case passed for ensureLoginButtonDisabled");
	}
	
	public void ensureDividerLabel() {
		String dividerLabel = driver.findElement(dividerLabel_Xpath).getText();
		Assert.assertEquals(dividerLabel, "Or");
		System.out.println("Test case passed for ensureDividerLabel");
	}
	
	public void ensureLoginPasswordButtonText() {
		String loginPasswordCTAText = driver.findElement(loginPasswordCTAText_Xpath).getText();
		Assert.assertEquals(loginPasswordCTAText, "Login With Password");
		System.out.println("Test case passed for ensureLoginPasswordButtonText");
	}
	
	public void ensureNoAccountText() {
		String noAccountText = driver.findElement(noAccountText_XPath).getText();
		Assert.assertEquals(noAccountText, "Don’t have an account?");
		System.out.println("Test case passed for ensureNoAccountText");
	}
	
	public void ensureRegisterNowCTAText() {
		String registerNowCTAText = driver.findElement(registerNowCTA_XPath).getText();
		Assert.assertEquals(registerNowCTAText, "Register Now");
		System.out.println("Test case passed for ensureRegisterNowCTAText");
	}
	
	public void clickOnLoginWithPasswordButton() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(loginPasswordCTAText_Xpath).click();
	}
	
	public void ensurePasswordPageLabel() {
		String passwordPageLabel = driver.findElement(passwordPageLabel_Xpath).getText();
		Assert.assertEquals(passwordPageLabel, "Log In to Your Account");
	}
	
	public void ensureEmailFieldText() {
		WebElement emailFieldText = driver.findElement(emailFieldText_ID);
		Assert.assertTrue(emailFieldText.isDisplayed());	
	}
	
	public void ensurePasswordFieldText() {
		String passwordFieldText = driver.findElement(passwordFieldText_ID).getText();
		Assert.assertEquals(passwordFieldText, "Password");
	}
	
	public void ensureForgotPasswordText() {
		String forgotPasswordText = driver.findElement(forgotPasswordText_Xpath).getText();
		Assert.assertEquals(forgotPasswordText, "Forgot Password?");
	}
	
	public void ensureLoginButtonText() {
		String loginButtonText = driver.findElement(loginButtonText_Xpath).getText();
		Assert.assertEquals(loginButtonText, "Login");
	}
	
	public void ensureLoginWithPinButtonText() {
		String loginWithPinButtonText = driver.findElement(loginWithPinButtonText_Xpath).getText();
		Assert.assertEquals(loginWithPinButtonText, "Login With PIN");
	}
	
	public void ensureTemporaryPinText() {
		String temporaryPinText = driver.findElement(temporaryPinText_Xpath).getText();
		Assert.assertEquals(temporaryPinText, "We will send you a temporary PIN for verification");
	}
	
	public void clickOnLoginWithPinButton() {
		WebElement loginwithPinButtonClick = driver.findElement(loginWithPinButtonText_Xpath);
		loginwithPinButtonClick.click();
	}
	
	public void ensureRedirectedURL() {
		String redirectedURL = driver.getCurrentUrl();
		Assert.assertEquals(redirectedURL, "https://code-stage.whjr.one/s/login");
	}
	
	public void enterMobileNumber(String mobileNumber) {		
		driver.findElement(mobileFieldInput_ID).sendKeys(mobileNumber);
	}
	
	public void clickOnSendVerificationCode() {
		driver.findElement(sendVerificationCodeButton_XPath).click();
	}
	
	public void ensureNoUserErrorMessage() {
		String noUserErrorMsg = driver.findElement(snackBarErrorMsg_Xpath).getText();
		System.out.println(noUserErrorMsg);
	}
	
	public void enterEmailAndPassword(String emailID, String password) {
		driver.findElement(emailFieldInput_ID).sendKeys(emailID);
		driver.findElement(passwordFieldInput_ID).sendKeys(password);
		driver.findElement(loginButton_Xpath).click();
	}
	
	public void ensureredirectionToDashboard() throws InterruptedException {
		Thread.sleep(3000);
		String actualdashboardURL = driver.getCurrentUrl();
		Assert.assertEquals(actualdashboardURL, "https://code-stage.whjr.one/s/dashboard");
	}
}
