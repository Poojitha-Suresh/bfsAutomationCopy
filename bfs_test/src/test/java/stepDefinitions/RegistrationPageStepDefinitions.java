package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegistrationPage;
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

	@When("I enter the phone number {string} and select grade {string} and click on schedule now button")
	public void i_enter_the_phone_number_and_select_grade_and_click_on_schedule_now_button(String phoneNumber, String grade) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterPhoneNumber(phoneNumber);
		registrationPage.selectGradeFromGradeBucket(grade);
		registrationPage.clicOnScheduleClassButton();
	}
	
	@When("I enter the phone number {string} and select grade {string}")
	public void i_enter_the_phone_number_and_select_grade(String phoneNumber, String grade) throws InterruptedException {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.enterPhoneNumber(phoneNumber);
		registrationPage.selectGradeFromGradeBucket(grade);
	}

	@Then("OTP modal with proper details and mobile number {string} should be displayed")
	public void otp_modal_with_proper_should_be_displayed(String mobileNumber) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
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
	
	@After
	public void tearDown() {
		RegistrationPage registrationPage = testContextSetup.pageObjectManager.getRegistrationPage();
		registrationPage.closeAllBrowsers();
	}
	


	
}
