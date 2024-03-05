package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.SlotBookingPage;
import pageObjects.TrialDashboardPage;
import utils.TestContextSetup;

public class TrialDashboardPageStepDefinitions {


	TestContextSetup testContextSetup;
	
	public TrialDashboardPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Then("Validate if student name is displayed")
	public void validate_if_student_name_is_displayed() throws InterruptedException {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureStudentName();
	}
	
	@Then("Validate if text Complete the trial class to get your certificate is displayed")
	public void validate_if_text_complete_the_trial_class_to_get_your_certificate_is_displayed() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureCertificateHeading();
	}
	
	@Then("Validate if certificate image is displayed")
	public void validate_if_certificate_image_is_displayed() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureCertificateImage();
	}
	
	@Then("Validate if helpdesk section has support number {string}")
	public void validate_if_helpdesk_section_has_support_number(String supportNumber) throws InterruptedException {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureSupportNumber(supportNumber);
	}
	
	@Then("Validate if helpdesk section has support email  {string}")
	public void validate_if_helpdesk_section_has_support_email(String supportEmail) throws InterruptedException {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureSupportEmail(supportEmail);
	}
	
	@Then("Verify if text {string} is shown")
	public void verify_if_text_is_shown(String scheduleTrialText) throws InterruptedException {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureScheduleClassText(scheduleTrialText);	
	}
	
	@Then("Verify if {string} CTA is shown")
	public void verify_if_cta_is_shown(String pickSlotText) throws InterruptedException {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensurePickASlotText(pickSlotText);
	}
	
	@Then("Verify if referral heading text {string} is shown")
	public void verify_if_referral_heading_text_is_shown(String referralBannerHeading) {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureReferralBannerText(referralBannerHeading);
	}
	
	@Then("I click on Click Now button and page should be redirected to referral page")
	public void i_click_on_click_now_button_and_page_should_be_redirected_to_referral_page() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.clickRefferalBannerDashButton();
	}
	
	@Then("Verify if dashboard text {string} is shown")
	public void verify_if_dashboard_text_is_shown(String dashVideoText) {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureDashboardVideoText(dashVideoText);
	}
	
	@Then("I click on dashboard Youtube pause video")
	public void i_click_on_dashboard_youtube_pause_video() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.clickOnDashboardVideo();
	}
	
	@Then("Verify if student name is displayed in website banner")
	public void verify_if_student_name_is_displayed_in_website_banner() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureStudentWebsiteHeading();
	}
	
	@Then("I click on student webiste CTA")
	public void i_click_on_student_webiste_cta() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.clickOnStudentWesbiteBtn();
	}
	
	@Then("Verify if URL of webiste page contains student name")
	public void verify_if_url_of_webiste_page_contains_student_name() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureStudentWebsiteName();
	}
	
	@Then("Verify if reviews heading {string} is displayed")
	public void verify_if_reviews_heading_is_displayed(String reviewHeading) {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureReviewsHeading(reviewHeading);
	}
	
	@Then("Verify if three review cards are displayed")
	public void verify_if_three_review_cards_are_displayed() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		trialDashboardPage.ensureReviewsCardCount();
	}
	
	@Then("Verify the UI elements on trial class scheduled card")
	public void verify_the_ui_elements_on_trial_class_scheduled_card() {
		TrialDashboardPage trialDashboardPage = testContextSetup.pageObjectManager.getTrialDashboardPage();
		
		// Verify if text 'Trial class scheduled! ' is shown
		trialDashboardPage.ensuretrialScheduledText();
		
		// Verify if text 'Your class starts in' is shown
		trialDashboardPage.ensureTrialStartsText();
		
		// Verify if heading 'Introduction to Coding' is shown
		trialDashboardPage.ensureTrialScheduledClassName();
		
		// Verify if the selected date and time slot is displayed 
		
		// Verify if countdown timer tile is shown
		
		// Verify if class joining instructions pointers are displayed
		
		// Verify if link text 'Set up your device for the class' is shown
		
		// Verify if join now text is displayed
	}

}
