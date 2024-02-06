package stepDefinitions;

import utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;


public class LoginPageStepDefinitions {
	
TestContextSetup testContextSetup;
	
	public LoginPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@When("I stay on that page")
	public void i_stay_on_that_page() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("UI elements on page should be displayed properly")
	public void ui_elements_on_page_should_be_displayed_properly() throws InterruptedException {
	    LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
	    Thread.sleep(5000);
	    loginPage.ensureBrandingLogoDisplayed();
	    loginPage.ensureLoginHeaderLabel();
	    loginPage.ensureDialCodeField();
	    loginPage.ensureMobileFieldLabel();
	    loginPage.ensureLoginButtonDisabled();
	    loginPage.ensureDividerLabel();
	    loginPage.ensureLoginPasswordButtonText();
	    loginPage.ensureNoAccountText();
	    loginPage.ensureRegisterNowCTAText();
	}
	
	@When("I click on Login With Password button")
	public void i_click_on_login_with_password_button() throws InterruptedException {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		Thread.sleep(5000);
		loginPage.clickOnLoginWithPasswordButton();
	}
	
	@Then("UI elements on login with password page should be displayed properly")
	public void ui_elements_on_login_with_password_page_should_be_displayed_properly() {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.ensurePasswordPageLabel();
		loginPage.ensureEmailFieldText();
		//loginPage.ensurePasswordFieldText();
		loginPage.ensureForgotPasswordText();
		loginPage.ensureLoginButtonText();
		loginPage.ensureDividerLabel();
		loginPage.ensureLoginWithPinButtonText();
		loginPage.ensureTemporaryPinText();
	    loginPage.ensureNoAccountText();
	    loginPage.ensureRegisterNowCTAText();
	}
	
	@When("I click on Login with PIN button")
	public void i_click_on_login_with_pin_button() {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.clickOnLoginWithPinButton();
	}
	
	@Then("I should be redirected back to login with mobile page")
	public void i_should_be_redirected_back_to_login_with_mobile_page() {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.ensureRedirectedURL();
		loginPage.ensureMobileFieldLabel();
	}
	
	@When("I click on Mobile number and enter {string}")
	public void i_click_on_mobile_number_and_enter(String mobileNumber) throws InterruptedException {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		Thread.sleep(2000);
		loginPage.enterMobileNumber(mobileNumber);
	}
	
	@When("I click on Send Verification Code button")
	public void i_click_on_send_verification_code_button() {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.clickOnSendVerificationCode();
	}
	
	@Then("Validate error message User not Found")
	public void validate_error_message_user_not_found() {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.ensureNoUserErrorMessage();
	}
	
	@When("I enter Email ID {string} and Password {string} and click on Login button")
	public void i_enter_email_id_and_password_and_click_on_login_button(String emailID, String password) {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.enterEmailAndPassword(emailID, password);
	}
	@Then("Validate user is redirected to dashboard")
	public void validate_user_is_redirected_to_dashboard() throws InterruptedException {
		LoginPage loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.ensureredirectionToDashboard();
	}



}
