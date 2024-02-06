package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.SlotBookingPage;
import utils.TestContextSetup;

public class SlotBookingPageStepDefinitions {

	TestContextSetup testContextSetup;
	
	public SlotBookingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	
	@When("I click on Pick a Slot")
	public void i_click_on_pick_a_slot() throws InterruptedException {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.clickOnPickSlotButton();
	}
	
	@When("I select a time slot")
	public void i_select_a_time_slot() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.selectTimeSlotEnabled();
	}
	
	@Then("slot should get selected and Confirm Slot CTA should get enabled")
	public void slot_should_get_selected_and_confirm_slot_cta_should_get_enabled() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureTimeSelectedAndCTA();
	}
	
	@When("I click on Timezone dropdown and select United Kingdom Time")
	public void i_click_on_timezone_dropdown_and_select_united_kingdom_time() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.clickAndSelectTimezone();
	}
	
	@Then("Validate selected timezone is displayed")
	public void validate_selected_timezone_is_displayed() throws InterruptedException {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureTimezoneDisplayed();
	}
	
	@When("I click on Confirm Slot CTA")
	public void i_click_on_confirm_slot_cta() throws InterruptedException {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.selectConfirmSlotButton();
	}
	@Then("Validate if user is redirected to trial success page")
	public void validate_if_user_is_redirected_to_trial_success_page() throws InterruptedException {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureRedirectedTrialSuccessPage();

	}
	
	@Then("Validate if language selection modal is shown")
	public void validate_if_language_selection_modal_is_shown() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureLanguageModalHeading();
	}
	
	@Then("Validate if all languages list are shown")
	public void validate_if_all_languages_list_are_shown() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureLanguageModalList();
	}
	
	@Then("Validate if Confirm CTA is disabled")
	public void validate_if_confirm_cta_is_disabled() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureConfirmLanguageButtonDisabled();
	}
	
	@When("I click privacy policy link")
	public void i_click_privacy_policy_link() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.clickOnPrivacyPolicyCTA();
	}
	
	@Then("Validate if privacy policy URL opens in new tab and has heading Privacy Policy")
	public void validate_if_privacy_policy_url_opens_in_new_tab_and_has_heading_privacy_policy() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.switchToPrivacyPolicyTab();
	}
	
	@Then("Validate if date is preselected")
	public void validate_if_date_is_preselected() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureDatePreselected();
	}
	
	@When("I click on English language and confirm selection")
	public void i_click_on_english_language_and_confirm_selection() throws InterruptedException {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.selectLanguage();
		slotBookingPage.selectConfirmSlotButton();
	}
	
	@When("I close update information modal")
	public void i_close_update_information_modal() throws InterruptedException {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		//slotBookingPage.closeUpdateInfoPopup();
	}
	
	@When("I click on Create student website")
	public void i_click_on_create_student_website() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.clickCreateWebsite();
	}
	
	@Then("Validate if url contains {string}")
	public void validate_if_url_contains(String string) {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureCreateWebsiteOpened();
	}
	
	@When("I click on Youtube pause video")
	public void i_click_on_youtube_pause_video() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.clickOnYoutubePause();
	}
	
	@Then("Validate if youtube video button is paused")
	public void validate_if_youtube_video_button_is_paused() {
		SlotBookingPage slotBookingPage = testContextSetup.pageObjectManager.getSlotBookingPage();
		slotBookingPage.ensureVideoIsPaused();
	}


	
}
