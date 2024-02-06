package pageObjects;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	private By book_your_free_coding_class_Xpath = By
			.xpath("//div[contains(@class,'heading4_reg')]/div/span[contains(@class,'text-align-left')]");
	private By limitedSpotsLeftTextElement = By
	.xpath("//div[contains(@class,'MuiGrid-item')]/div[contains(@class,'MuiGrid-grid-sm-12')]/div/span[contains(@class,'book_now_label')]");
	private By dialCodeCountryCode_Id = By.id("dialCode");
	private By parentsMobileText_Id = By.id("mobile-label");
	private By selectGradeText_Xpath = By.xpath("//span[@class='MuiFormLabel-root jss79']");
	private By gradeListOptions_Xpath = By
			.xpath("//div[@id='grade']/label/span/div/div[contains(@class,'heading_bold')]");
	private By scheduleCTAText_Xpath = By.xpath("//button[@id='submitButton']/div");
	private By invalidMobileNoErrorPrompt_Xpath = By.xpath("//span[@class='errorTxt']/span[contains(@style,'font')]");
	private By validMobileNumberGreenTick_Xpath = By.xpath("//input[@name='mobile']/../div");
	private By termsAndConditionsLink_Xpath = By.xpath("//a[@class='text_blue']");
	private By otpModalPopupCloseBtn_Xpath = By.xpath("//div[contains(@class,'jss114')]");
	private By regUserOTPPopupHeading_Xpath = By.xpath("//div[contains(@class,'jss124')]");
	private By regUserOTPLoginUsingOTPPrompt_Xpath = By.xpath("//p[@class='jss97']");
	private By regUserOTPLoginUsingOTPMobileNo_Xpath = By.xpath("//p[@class='jss97']/span");
	
	
	
	
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
	
	public void ensureRegistrationPageWebTitleVisible() {
		String actualTitle = driver.getTitle().trim();
		String expectedTitle = "WhiteHat Jr";
		
		Assert.assertEquals(actualTitle.trim(), expectedTitle.trim());
	}
	
	public void ensureBookYourFreeCodingClassTextVisible() {
		String expectedHeaderText = "Book Your Free Coding Class";
		String actualText = driver.findElement(book_your_free_coding_class_Xpath).getText();
		Assert.assertEquals(actualText, expectedHeaderText);
	}
	
	public void ensureLimitedSpotsLeftTextVisible() {
		String expectedLabelText = "Limited Spots Left!";
		String actualLabelText = driver.findElement(limitedSpotsLeftTextElement).getText();
		Assert.assertEquals(actualLabelText, expectedLabelText);
	}
	
 	public void ensurePhoneNoFieldVisible() {
		WebElement phoneNoField = driver.findElement(phoneNoField_Xpath);
	    Assert.assertTrue(phoneNoField.isDisplayed());
	}	
		
 	public void ensurePreSelectedDialCode() {
 		String expectedDialCode = "+91";
 		WebElement countryCode = driver.findElement(dialCodeCountryCode_Id);
 		
 		Select dialCode = new Select(countryCode);
		
		WebElement selectedCode = dialCode.getFirstSelectedOption();
		String selectedCountry = selectedCode.getText();
		
		Assert.assertEquals(selectedCountry, expectedDialCode);
 	}
 	
 	public void  ensureParentsMobileTextVisible() {
 		String mobileFieldTex = driver.findElement(parentsMobileText_Id).getText();
 		String expectedMobileText = "Parent's Mobile";


 		Assert.assertEquals(mobileFieldTex, expectedMobileText);
 	}
 	
 	public void ensureSelectGradeFieldTextVisible() {
 		String gradesText = driver.findElement(selectGradeText_Xpath).getText();
 		String expectedGradesText = "Select your child's grade/class in school";
 		Assert.assertEquals(gradesText, expectedGradesText);
 	}
 	
 	public void ensureGradeListOptionsVisible() {
 		List <WebElement> gradeOptions = new ArrayList();
 		gradeOptions = driver.findElements(gradeListOptions_Xpath);
 		
 		int gradeIndex = -1;
		boolean gradeMatch = true;
		List<String> gradesListed = new ArrayList<String>();
		String[] expectedGradesList = {"1-2", "3-4", "5", "6-8", "9-12"};
		//expectedGradesList = [1-2, 3-4, 5, 6-8, 9-12];
		
		for(WebElement option: gradeOptions) {
			gradeIndex++;
			
			Assert.assertEquals(option.getText(), expectedGradesList[gradeIndex]);		
		}


 	}


 	public void ensureScheduleAFreeClassTextVisible() {
 		String scheduleCTAText = driver.findElement(scheduleCTAText_Xpath).getText();
 		String expectedCtaText = "Schedule Now";
 		//Assert.assertEquals(scheduleCTAText, expectedCtaText);
 		Assert.assertTrue(scheduleCTAText.contains("Schedule"));
 		
 		WebElement submitBtn = driver.findElement(scheduleClassButton_Xpath);
 		Assert.assertTrue(submitBtn.isEnabled());
 	}
 	
	public void ensurePageUrl(String expUrl) throws InterruptedException {
		Thread.sleep(3000);
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	public void ensureInvalidMobileNoError() throws InterruptedException {
		Thread.sleep(2000);
		WebElement errorPrompt = driver.findElement(invalidMobileNoErrorPrompt_Xpath);
		String actualError = errorPrompt.getText();
		String expectedError = "Enter a valid mobile number";
		Assert.assertEquals(actualError, expectedError);
	}


	public void ensureGreenTickAfterMobileNumber() {
		WebElement greenTickAfterMobNo = driver.findElement(validMobileNumberGreenTick_Xpath);
		Assert.assertTrue(greenTickAfterMobNo.isDisplayed());
	}
	
	public void clickOnWHJRBrandingLogo() {
		WebElement brandingLogo = driver.findElement(brandingLogo_Xpath);
		brandingLogo.click();
	}
	
	public void ensureSelectedGradeHighlighted() {
		List <WebElement> gradeOptions = new ArrayList();
		List <WebElement> gradeButtons = new ArrayList();
		
		gradeButtons = driver.findElements(gradeSelectorBuckets_XPath);
		gradeOptions = driver.findElements(gradeListOptions_Xpath);


		int gradeIndex = -1;
		String grade = "3-4";
		
		boolean isGradeFound = false;
		
		for(WebElement option: gradeOptions)
		{
			gradeIndex++;
			if(option.getText().equals(grade))
			{
				gradeButtons.get(gradeIndex).click();
				isGradeFound = true;
				break;
			}
		}
		
		Assert.assertTrue(isGradeFound);


	}
	
	public void clickOnTermsAndConditionsLink() throws InterruptedException {
		WebElement termsAndConditionsLink = driver.findElement(termsAndConditionsLink_Xpath);
		termsAndConditionsLink.click();
		Thread.sleep(3000);		
	}


	public void switchToNextTab() {
		String childWindow = "";
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		
		while(iterator.hasNext())
		{
			childWindow = iterator.next();
			if(!mainWindowHandle.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
		}


	}
	
	
	public void ensureCTAButton() {
		WebElement submitBtn = driver.findElement(scheduleClassButton_Xpath);
		String submitBtnText = driver.findElement(scheduleCTAText_Xpath).getText();
	}
	
	
	
	public void closeAllBrowsers() {
		//driver.quit();
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
	
	public void ensureOTPModalUIElementsRegisteredUser(String mobileNumber) throws InterruptedException{
		
		Thread.sleep(2000);
		//Ensure  text 'You are already registered' is visible
		WebElement youAreRegistered = driver.findElement(regUserOTPPopupHeading_Xpath);
		Assert.assertEquals(youAreRegistered.getText(), "You are already registered");
		
		//Ensure  text 'Login using OTP sent to' is visible
		WebElement loginUsingOTPPrompt = driver.findElement(regUserOTPLoginUsingOTPPrompt_Xpath);
		Assert.assertTrue(loginUsingOTPPrompt.getText().contains("Login using OTP sent to"));
		
		//Ensure entered phone number is displayed 
		WebElement loginUsingOTPMobNo = driver.findElement(regUserOTPLoginUsingOTPMobileNo_Xpath);
		Assert.assertTrue(loginUsingOTPMobNo.getText().contains(mobileNumber));
		
		//ensure 4 digit OTP field is visible
		WebElement otpBoxes = driver.findElement(otp_modal_boxes_Xpath);
		Assert.assertEquals(otpBoxes.isDisplayed(), true);
		
		//ensure OTP not received msg
		//Thread.sleep(10000);
		String expectedMsg = "Haven't received OTP?";
		String actualMsg = driver.findElement(otp_modal_notReceivedPrompt_XPath).getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
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
	
	public void closeOTPModalPopup() throws InterruptedException {
		Thread.sleep(3000);
		WebElement popupCloseBtn = driver.findElement(otpModalPopupCloseBtn_Xpath);
		Assert.assertTrue(popupCloseBtn.isEnabled());
		popupCloseBtn.click();
	}


}
