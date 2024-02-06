package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegistrationPage;
//import pageObjects.TermsAndConditionsPage;
import utils.TestContextSetup;


public class RegistrationPageStepDefinitions {
	
	TestContextSetup testContextSetup;
	
	public RegistrationPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Given("I navigate to the url {string}")
	public void i_navigate_to_the_url(String url) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
	    registrationPage.navigateToUrl(url);
	}
	
	@Then("Validate the UI Elements of the Registration Page for India")
	public void validate_the_ui_elements_of_the_registration_page_for_india() {
		
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		
		//ensure Page title 'Whitehat Jr' is visible
		registrationPage.ensureRegistrationPageWebTitleVisible();
		
		//ensur WhitehatJr branding logo is visible		
	    registrationPage.ensure_WHJR_BrandingLogo_Visible();
	    
		//ensure  'Book Your Free Coding Class' text is visible
	    registrationPage.ensureBookYourFreeCodingClassTextVisible();
	    
		//ensure 'Limited Spots Left!' text is visible
	    registrationPage.ensureLimitedSpotsLeftTextVisible();
	    
		//ensure  +91 dial code is preselected
	    registrationPage.ensurePreSelectedDialCode();
	    
		//ensure 'Parent's Mobile' text is visible
	    registrationPage.ensureParentsMobileTextVisible();
	    
		//ensure 'Select your child's grade/class in school' text is visible'
	    registrationPage.ensureSelectGradeFieldTextVisible();
	    
		//ensure grades field have grade buckets 'Grade 1-2', 'Grade 3-4','Grade 5', 'Grade 6-8', 'Grade 9-12'
	    registrationPage.ensureGradeListOptionsVisible();
	    
		//esnure  'Schedule a Free Class' text is visible 
	    registrationPage.ensureScheduleAFreeClassTextVisible();
	}
	
	@When("I enter the phone number {string}")
	public void i_enter_the_phone_number(String phoneNumber) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterPhoneNumber(phoneNumber);
	}
	@When("I click outside the phone number field")
	public void i_click_outside_the_phone_number_field() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.clickOnWHJRBrandingLogo();
	}
	
	@Then("A tick mark should appear after the {int} digit mobile number")
	public void a_tick_mark_should_appear_after_the_digit_mobile_number(Integer int1) {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureGreenTickAfterMobileNumber();
	}
	
	@Then("Error message Enter a valid mobile number should be displayed")
	public void error_message_should_be_displayed() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureInvalidMobileNoError();
	}


	@When("I enter the phone number {string} and select grade {string} and click on schedule now button")
	public void i_enter_the_phone_number_and_select_grade_and_click_on_schedule_now_button(String phoneNumber, String grade) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterPhoneNumber(phoneNumber);
		registrationPage.selectGradeFromGradeBucket(grade);
		registrationPage.clicOnScheduleClassButton();
	}
	
	@When("I select grade {string}")
	public void i_select_grade(String grade) {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.selectGradeFromGradeBucket(grade);
	}
	
	@Then("Selected grade bucket should be highlighted with Orange colour")
	public void selected_grade_bucket_should_be_highlighted_with_orange_colour() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureSelectedGradeHighlighted();
	}
		
	@When("I enter the phone number {string} and select grade {string}")
	public void i_enter_the_phone_number_and_select_grade(String phoneNumber, String grade) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterPhoneNumber(phoneNumber);
		registrationPage.selectGradeFromGradeBucket(grade);
	}


	@Then("OTP modal with proper details and mobile number {string} should be displayed")
	public void otp_modal_with_proper_should_be_displayed(String mobileNumber) throws InterruptedException {
	    
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureOTPModalUIElements(mobileNumber);
	}
	
	@When("I enter the OTP received on mobile number {string}")
	public void i_enter_the_otp(String mobNo) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterOTP(mobNo);
	}


	@Then("Validate that I am redirected to the url {string}")
	public void validate_that_i_am_redirected_to_the_url(String url) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensurePageUrl(url);	    
	}
	
	@When("I enter invalid OTP")
	public void i_enter_invalid_otp() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterInvalidOTP();
	}
	
	@Then("Error msg should be displayed on OTP Modal Popup")
	public void error_msg_should_be_displayed_on_otp_modal_popup() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureInvalidOTPErrorMessage();
	}
	
	@When("I click on Resend via call")
	public void i_click_on_resend_via_call() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.clickResendOTP("Resend via Call");
	}
	
	@Then("Validate text OTP has been sent")
	public void validate_text_otp_has_been_sent() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
	    registrationPage.ensureTextOTPSent();
	}
	
	@When("I click on Resend via SMS")
	public void i_click_on_resend_via_sms() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.clickResendOTP("Resend via SMS");
	}
	
	@When("I click on Terms & Condition link")
	public void i_click_on_terms_condition_link() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.clickOnTermsAndConditionsLink();
	}
	
//	@Then("A new tab should open with url:{string} and heading {string}")
//	public void a_new_tab_should_open_with_url_and_heading(String url, String heading) throws InterruptedException {
//		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
//		registrationPage.switchToNextTab();
//		registrationPage.ensurePageUrl("https://code-stage.whjr.one/terms-conditions");
//		
//		//Calling method of Terms And Conditions page as need to verify opened tab page heading
//		TermsAndConditionsPage termsAndConditionsPage = testContextSetup.pageObjectManager.getTermsAndConditionsPage();
//		termsAndConditionsPage.ensureTermsAndConditionsPageHeadingDisplayed(heading);
//	}
	
	@When("I enter the phone number {string} and click on Schedule Now CTA button")
	public void i_enter_the_phone_number_and_click_on_schedule_now_cta_button(String phoneNumber) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterPhoneNumber(phoneNumber);
		registrationPage.clicOnScheduleClassButton();
	}
	
	@Then("Ensure CTA button is enabled")
	public void ensure_cta_button_is_enabled() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureScheduleAFreeClassTextVisible();
	}
	
	@Then("Error message Childs Grade is required should be displayed")
	public void error_message_childs_grade_is_required_should_be_displayed() {
	}
	
	@When("Wait for resend link and Click resend OTP on OTP Modal pop-up for mobile number {string}")
	public void wait_for_resend_link_and_click_resend_otp_on_otp_modal_pop_up(String PhoneNumber) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureOTPModalUIElements(PhoneNumber);
		registrationPage.clickResendOTP(PhoneNumber);
		registrationPage.ensureTextOTPSent();
	}
	
	@When("Close the OTP Popup")
	public void close_the_otp_popup() throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.closeOTPModalPopup();
	}
	@Then("Validate that the OTP Pop-up is closed")
	public void validate_that_the_otp_pop_up_is_closed() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		//ensure  'Book Your Free Coding Class' text is visible
	    registrationPage.ensureBookYourFreeCodingClassTextVisible();
	    
		//ensure 'Limited Spots Left!' text is visible
	    registrationPage.ensureLimitedSpotsLeftTextVisible();
	    
		//ensure  +91 dial code is preselected
	    registrationPage.ensurePreSelectedDialCode();
	    
		//ensure 'Parent's Mobile' text is visible
	    registrationPage.ensureParentsMobileTextVisible();
	    
		//ensure 'Select your child's grade/class in school' text is visible'
	    registrationPage.ensureSelectGradeFieldTextVisible();
	    
		//ensure grades field have grade buckets 'Grade 1-2', 'Grade 3-4','Grade 5', 'Grade 6-8', 'Grade 9-12'
	    registrationPage.ensureGradeListOptionsVisible();
	    
		//esnure  'Schedule a Free Class' text is visible 
	    registrationPage.ensureScheduleAFreeClassTextVisible();
	}
	
	
	@Then("Validate that the OTP Pop-up for registered user {string}")
	public void validate_that_the_otp_pop_up_for_registered_user(String mobNo) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.ensureOTPModalUIElementsRegisteredUser(mobNo);
	}
	
	
	
	
	
	@After
	public void tearDown() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.closeAllBrowsers();


	}
	




	
}
