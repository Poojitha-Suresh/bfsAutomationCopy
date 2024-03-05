package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

//import groovy.time.Duration;

public class SlotBookingPage {

public WebDriver driver;
	
	//class constructor
	public SlotBookingPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	//===================== locators ===================================
	private By pickASlotButton_Xpath = By.xpath("//div[contains(@class,'h-100')]/a/button[contains(@class,'btn_orange')]");
	private By timezoneDropDownButton_Xpath = By.xpath("//div[contains(@class,'overflow-hidden')]/div/div");
	private By timezoneDisplayed_Xpath = By.xpath("//span[contains(@class,'overflow-hidden')]");
	private By clickOnChangeButton_Xpath = By.xpath("//div[@role='dialog']/div/div[contains(@class,'d-flex')]/div/span[@color='#fb7a27']");
	private By timezoneList_Xpath = By.xpath("//span[contains(@class,'MuiListItemText-primary')]");
	private By timeSlotList_Xpath = By.xpath("//input[@name = 'radio-group']");
	private By timeSlotSelection_Xpath = By.xpath("//input[@name = 'radio-group']/..");
	private By confirmSlotButton_ID = By.id("submitButton");
	private By languageModalHeading_Xpath = By.xpath("//div[@role='dialog']/div/form/h1");
	private By languageModalList_Xpath = By.xpath("//span[contains(@class,'FormRadioFieldLanguage')]");
	private By privacyPolicyCTA_Xpath = By.xpath("//a[@href='/privacy-policy']");
	private By privacyPolicyPageHeading_Xpath = By.xpath("//div[contains(@class,'container-fluid')]/div/div/div/span");
	private By slotsContainerDate_Xpath = By.xpath("//div[contains(@class,'slots-date-container')]/div/div/div[contains(@class,'jss61')]");
	private By selectedDateText_Xpath = By.xpath("//div[contains(@class, 'heading_semi')]/span");
	private By selectedTime_Xpath = By.xpath("//span[contains(@class,'icon-check-mark-black-outline')]");
	private By languageTextList_Xpath = By.xpath("//span[@class='FormRadioFieldLanguage__LangName-sc-1ywis8w-1 bjhjug']");
	private By updateInfoCloseButton_Xpath = By.xpath("//button[@aria-label='close']");
	private By createWebsiteButton_Xpath = By.xpath("//button[@class='create_btn btn roboto_bold mt-2']");
	private By trialSuccessYoutube_Xpath = By.xpath("//iframe[contains(@src,'https://www.youtube-nocookie.com/embed/TSdaqIt8c2g?autoplay=1&mute=1&rel=0')]");
	private By trialSuccessYoutubePause_Xpath = By.xpath("//button[contains(@class, 'ytp-play-button')]");
	
	
	//==================================================================

	
	//===================== Common Methods =============================

	public void clickOnPickSlotButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(pickASlotButton_Xpath).click();
	}
	
	public void clickAndSelectTimezone() {
		driver.findElement(timezoneDropDownButton_Xpath).click();
		driver.findElement(clickOnChangeButton_Xpath).click();
		
		//String timezoneListText = driver.findElements(timezoneList_Xpath).getText();
		List<WebElement> timezonelistElement = driver.findElements(timezoneList_Xpath);
		for(int i=0; i<timezonelistElement.size(); i++) {
			String timezoneListText = timezonelistElement.get(i).getText();
			if(timezoneListText.contains("United Kingdom Time")) {
				System.out.println("UK list" + timezoneListText);
				timezonelistElement.get(i).click();
				break;
			}	
		}
	}
	
	public void ensureTimezoneDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		String timezoneDisplayedText = driver.findElement(timezoneDisplayed_Xpath).getText();
		Assert.assertEquals(timezoneDisplayedText, "(GMT+00:00) GMT");
	}
	
	public void selectTimeSlotEnabled() {
		List<WebElement> timeSlotsList = driver.findElements(timeSlotList_Xpath);
		List<WebElement> timeSlotSelection = driver.findElements(timeSlotSelection_Xpath);
		//System.out.println(timeSlotsList);
		for(int i=0; i<timeSlotsList.size(); i++) {
			//System.out.println("for loop "+timeSlotsList.get(i));
			if(timeSlotsList.get(i).isEnabled()) {
				//System.out.println("if condition"+ timeSlotsList.get(i));
				timeSlotSelection.get(i).click();
				break;
			}
		}	
	}
	
	public void ensureTimeSelectedAndCTA() {
		driver.findElement(selectedTime_Xpath).isSelected();
		driver.findElement(confirmSlotButton_ID).isEnabled();
	}
	
	public void selectConfirmSlotButton() throws InterruptedException{
		driver.findElement(confirmSlotButton_ID).click();
		Thread.sleep(5000);
	}
	
	public void ensureRedirectedTrialSuccessPage() throws InterruptedException {
		Thread.sleep(5000);
		String actualSuccessPage = driver.getCurrentUrl();
		Assert.assertEquals(actualSuccessPage, "https://code-stage.whjr.one/s/trial/success?click_source=pick_slotfalse");
	}
	
	public void ensureLanguageModalHeading() {
		String actualLanguageModalHeading = driver.findElement(languageModalHeading_Xpath).getText();
		Assert.assertEquals(actualLanguageModalHeading, "Our teachers speak many languages! Pick your choice:");
	}
	
	public void ensureLanguageModalList() {
		List<WebElement> languageList = driver.findElements(languageModalList_Xpath);
		List<String> all_languageList_text=new ArrayList<>();
		String[] expected_languageList_text = {"Hindi", "Gujarati", "Kannada","Marathi", "Bengali", "Tamil", "Telugu", "English"};
		
	    for(int i=0; i<languageList.size(); i++){
	    	all_languageList_text.add(languageList.get(i).getText());
	        System.out.println(languageList.get(i).getText());
	        if(all_languageList_text.get(i).equals(expected_languageList_text[i])) {
	        	System.out.println("Element matches");
	        }
	        
	    }
	}
	
	public void ensureConfirmLanguageButtonDisabled() {
		boolean confirmLanguageButton = driver.findElement(confirmSlotButton_ID).isEnabled();
		Assert.assertTrue(!confirmLanguageButton);
	}
	
	public void clickOnPrivacyPolicyCTA() {
		driver.findElement(privacyPolicyCTA_Xpath).click();
	}
	
	public void switchToPrivacyPolicyTab() {
		
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
		
		String privacyHeadingText = driver.findElement(privacyPolicyPageHeading_Xpath).getText();
		Assert.assertEquals(privacyHeadingText, "Privacy Policy");
		
		driver.switchTo().window(mainWindowHandle);

	}
	
	public void ensureDatePreselected() {
		List<WebElement> dateList = driver.findElements(slotsContainerDate_Xpath);
		
		for(int i=0; i<dateList.size(); i++) {
			String preSelectedDate = dateList.get(i).getText();
			String displayedDate = driver.findElement(selectedDateText_Xpath).getText();
			System.out.println(preSelectedDate + displayedDate);
			if(displayedDate.contains(preSelectedDate)) {
				Assert.assertTrue(true);
				break;
			}
		}
	}
	
	public void selectLanguage() throws InterruptedException {
		List<WebElement> languageListText = driver.findElements(languageTextList_Xpath);
		for(int i=0; i<languageListText.size(); i++) {
			String languageText = languageListText.get(i).getText();
			System.out.println(languageText);
			if(languageText.equalsIgnoreCase("English")) {
				Thread.sleep(3000);
				languageListText.get(i).click();
				break;
			}
		}	
	}
	
	public void closeUpdateInfoPopup() throws InterruptedException {
		//WebElement closeButton = driver.findElement(updateInfoCloseButton_Xpath);
		if(driver.findElement(updateInfoCloseButton_Xpath).isDisplayed()) {
			driver.findElement(updateInfoCloseButton_Xpath).click();
		}
		else {
			System.out.println("Update info popup not shown");
		}
	}
	
	public void clickCreateWebsite() {		
		//Duration d = Duration.ofSeconds(30);// Failing
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
//		WebElement webisteCTA = wait.until(ExpectedConditions.elementToBeClickable(createWebsiteButton_Xpath));
//		webisteCTA.click();
		
		WebElement webisteCTA = driver.findElement(createWebsiteButton_Xpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webisteCTA);
		webisteCTA.click();
	}
	
	public void ensureCreateWebsiteOpened() {
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
				String createWebsiteURL = driver.getCurrentUrl();
				createWebsiteURL.contains("whjr.site/users");
			}
		}
		driver.switchTo().window(mainWindowHandle);		
	}
	
	public void clickOnYoutubePause() {
		WebElement youtubeIframe = driver.findElement(trialSuccessYoutube_Xpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", youtubeIframe);
		driver.switchTo().frame(youtubeIframe);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		
		WebElement ytbPauseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(trialSuccessYoutubePause_Xpath));
		ytbPauseElement.click();
	}
	
	public void ensureVideoIsPaused() {
		String ytAttributeValue = driver.findElement(trialSuccessYoutubePause_Xpath).getAttribute("data-title-no-tooltip");
		System.out.println(ytAttributeValue);
		Assert.assertEquals(ytAttributeValue, "Play");
	}
}

