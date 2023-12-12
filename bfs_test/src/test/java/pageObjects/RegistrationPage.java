package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.OTPGenerator;

public class RegistrationPage {
	
	public WebDriver driver;
	
	//class constructor
	public RegistrationPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	//===================== locators ===================================
	private By brandingLogo_Xpath = By.xpath("//div[contains(@class,'container-fluid')]/div/div/div/div/div/div/h6/img");
	private By phoneNoField_Xpath = By.xpath("//input[@name='mobile']");
	private By gradeSelectorBuckets_XPath 
		= By.xpath("//div[@id='grade']/label");
	private By scheduleClassButton_Xpath = By.xpath("//button[@type='submit']");
	private By otp_boxes_Xpath = By.xpath("//div[@class='jss118']/div");
	private By otp_modal_boxes_Xpath = By.xpath("//input[@class='jss119']");
	private By otp_modalHeading_Xpath = By.xpath("//div[contains(@class,'jss124 heading_bold')]");
	private By otp_modalMobileNo_Xpath = By.xpath("//p/span[@class='whiteSpaceNo']");
	private By otp_modal_notReceivedPrompt_XPath = By.xpath("//div[@class='jss100']");
	private By otp_modal_notReceivedLink_XPath = By.xpath("//div[@class='jss123']/div/span");
	private By otp_modal_invalidOTP_msg_Xpath = By.xpath("//span[@class='jss113']");
	private By otp_modal_OTPResentPrompt_XPath = By.xpath("//div[@class='jss101']");
	
	
	//==================================================================
	
	
	
	//===================== Common Methods =============================
	public void navigateToUrl(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
	}
	
	//i_enter_the_phone_number_and_select_grade_and_click_on_schedule_now_button
	public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
		Thread.sleep(1000);
		WebElement phoneNoField = driver.findElement(phoneNoField_Xpath);
		phoneNoField.sendKeys(phoneNumber);
	}
	
	public void selectGradeFromGradeBucket(String grade) {
		List<WebElement> gradeBuckets = driver.findElements(gradeSelectorBuckets_XPath);
		for(WebElement gradeOption: gradeBuckets) {
			if(gradeOption.getAttribute("id").equals(grade)) {
				gradeOption.click();			
			}
		}
	}
	
	public void clicOnScheduleClassButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(scheduleClassButton_Xpath).click();
	}
	
	public void ensure_WHJR_BrandingLogo_Visible() {
		WebElement brandingLogo = driver.findElement(brandingLogo_Xpath);
	    Assert.assertTrue(brandingLogo.isDisplayed());
	}
	
	public void ensurePhoneNoFieldVisible() {
		WebElement phoneNoField = driver.findElement(phoneNoField_Xpath);
	    Assert.assertTrue(phoneNoField.isDisplayed());
	}	
		
	public void ensurePageUrl(String expUrl) throws InterruptedException {
		Thread.sleep(3000);
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	public void closeAllBrowsers() {
		driver.quit();
	}
	
	
	
	
	
	
	
	//====================================================================
	
	
	//===================== OTP Modal Methods=============================
	
	public void ensureOTPModalUIElements(String mobileNumber) throws InterruptedException {
		//ensure heading text
		Thread.sleep(6000);
		String modalHeading = driver.findElement(otp_modalHeading_Xpath).getText();
		Assert.assertEquals(modalHeading, "Enter the 4-digit OTP");
		
		//ensure entered mobile number is displayed
		String expectedMobNo = "+91 "+ mobileNumber;
		String modalMobNo = driver.findElement(otp_modalMobileNo_Xpath).getText();
		Assert.assertEquals(modalMobNo, expectedMobNo);
		
		//ensure 4 digit OTP field is visible
		WebElement otpBoxes = driver.findElement(otp_modal_boxes_Xpath);
		Assert.assertEquals(otpBoxes.isDisplayed(), true);
		
		//ensure OTP not received msg
		Thread.sleep(10000);
		String expectedMsg = "Haven't received OTP?";
		String actualMsg = driver.findElement(otp_modal_notReceivedPrompt_XPath).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		
		
		//ensure otp not received links
		List<WebElement> links = driver.findElements(otp_modal_notReceivedLink_XPath);
		List<String> msgs = new ArrayList<String>();
		for(WebElement link: links) {
			msgs.add(link.getText());
		}
		Assert.assertEquals(msgs.get(0).trim(), "Resend via Call");
		Assert.assertEquals(msgs.get(1).trim(), "Resend via SMS");		
	}
	
	public void enterOTP(String mobileNumber) throws InterruptedException {
		//Fetch the OTP
		String otp = OTPGenerator.getOTPForNewUser(mobileNumber);
		if(otp==null) {
			otp="0000";
		}
		
		Thread.sleep(2000);
		List<WebElement> otpBoxes = driver.findElements(otp_boxes_Xpath);		
		for(int i = 0; i<4; i++) {	
			String otpToEnter = "";
			new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='jss119']")))
				.click();
			otpToEnter = otpToEnter+ otp.charAt(i);
			driver.findElement(By.xpath("//input[@class='jss119']")).sendKeys(otpToEnter);
		}
	}
	
	public void ensureInvalidOTPErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		String expErrMsg = "Invalid OTP. Please try again";
		String actErrMsg = driver.findElement(otp_modal_invalidOTP_msg_Xpath).getText();
		Assert.assertEquals(actErrMsg, expErrMsg);
	}

	public void enterInvalidOTP() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> otpBoxes = driver.findElements(otp_boxes_Xpath);		
		for(int i = 0; i<4; i++) {	
			String otpToEnter = "0";
			new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='jss119']")))
				.click();
			driver.findElement(By.xpath("//input[@class='jss119']")).sendKeys(otpToEnter);
		}
	}

	public void clickResendOTP(String linkType) throws InterruptedException {
		Thread.sleep(16000);
		List<WebElement> links = driver.findElements(otp_modal_notReceivedLink_XPath);
		for(WebElement link: links) {
			if(link.getText().equalsIgnoreCase(linkType)) {
				link.click();		
				break;
			}
		}
	}

	public void ensureTextOTPSent() {
		String expPrompt = "OTP has been resent.";
		String actPrompt = driver.findElement(otp_modal_OTPResentPrompt_XPath).getText();
		Assert.assertEquals(actPrompt, expPrompt);
	}

}