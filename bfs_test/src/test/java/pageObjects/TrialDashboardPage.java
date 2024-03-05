package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TrialDashboardPage {

public WebDriver driver;
	
	//class constructor
	public TrialDashboardPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	//===================== locators ===================================
	
	public By studentNameDashboard_Xpath = By.xpath("//div[contains(@class,'bg_light_pitch')]/div/div/div[contains(@class, 'heading_bold')]");
	public By certificateHeading_Xpath = By.xpath("//div[contains(@class,'bg_light_pitch')]/div/div/div[contains(@class, 'heading3_semi')]");
	public By certificateImage_XPath = By.xpath("//img[@alt='Certificate']");
	public By supportNumber_Xpath = By.xpath("//div[contains(@class, 'icon-phone')]/../div[contains(@class,'heading3_bold')]");
	public By supportEmail_Xpath = By.xpath("//div[contains(@class, 'icon-mail')]/../div[contains(@class,'heading3_bold')]");
	private By scheduleFreeClassText_Xpath = By.xpath("//div[contains(@class,'h-100')]/div/div[contains(@class,'mb-2')]/span");
	private By pickASlotButton_Xpath = By.xpath("//div[contains(@class,'h-100')]/a/button[contains(@class,'btn_orange')]");
	private By referEarnBannerHeading_Xpath = By.xpath("//div[@class='main-content']/h5[contains(@class, 'jAKBEz')]");
	private By referEarnBannerButton_Xpath = By.xpath("//div[@class='sub-content']/button[contains(@class, 'kIJmEg')]");
	private By dashboardVideoHeading_Xpath = By.xpath("//div[contains(@class, 'slick-current')]/div/div/p");
	private By dashboardStudentName_Xpath = By.xpath("//div[contains(@class, 'bg_light_pitch')]/div/div/div[contains(@class,'heading_bold')]");
	private By createWebsiteHeading_Xpath = By.xpath("//div[contains(@class,'d-md-block')]/div[@class='sc-gHboQg cenGzI']/div/div");
	private By studentWebsiteButton_Xpath = By.xpath("//div[contains(@class,'d-md-block')]/div[@class='sc-gHboQg cenGzI']/div/span/button");
	private By dashboardYTVideo_Xpath = By.xpath("//iframe[@src=\"https://www.youtube-nocookie.com/embed/TSdaqIt8c2g?autoplay=1&mute=1&rel=0#t=0.001\"]");
	private By dashboardYTPause_Xpath = By.xpath("//button[contains(@class, 'ytp-play-button')]");
	private By reviewsHeading_Xpath = By.xpath("//div[contains(@class, 'd-md-block')]/div/div[@class='row align-items-center']/div/div[contains(@class, 'heading_bold')]");
	private By reviewsCards_Xpath = By.xpath("//div[contains(@class, 'd-md-block')]/div/div[@class='row align-items-center']/div[@class='col-12 ']/div/div/div/div/div/div");
	private By trialClassScheduledtext_Xpath = By.xpath("//div[@class='row align-items-center']/div/div[@class='trial-class-msg-header fpt-n']");
	private By trialClassStartsTimerText_Xpath = By.xpath("//div[@class='row align-items-center']//div[@class='class-start fpt-m']");
	private By trialDashboardClassName_Xpath = By.xpath("//div[@class='row align-items-center']//div[@class='n-content-head fpt-b']");	
	
	//==================================================================

	
	//===================== Common Methods =============================
	
	public void ensureStudentName() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(studentNameDashboard_Xpath).isDisplayed();
	}
	
	public void ensureCertificateHeading() {
		driver.findElement(certificateHeading_Xpath).getText().contains("Complete the trial class to ");
	}
	
	public void ensureCertificateImage() {
		driver.findElement(certificateImage_XPath).getAttribute("src").contains("https://s3");
	}
	
	public void ensureSupportNumber(String supportNum) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement supportNumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(supportNumber_Xpath));
		String getSupportNum = supportNumElement.getText();
		Assert.assertEquals(getSupportNum, supportNum);
	}
	
	public void ensureSupportEmail(String supportMail) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement supportEmailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(supportEmail_Xpath));
		String getSupportMail = supportEmailElement.getText();
		Assert.assertEquals(getSupportMail, supportMail);
	}
	
	public void ensureScheduleClassText(String scheduleText) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement scheduleTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(scheduleFreeClassText_Xpath));
		String getScheduleText = scheduleTextElement.getText();
		Assert.assertEquals(getScheduleText, scheduleText);
	}
	
	public void ensurePickASlotText(String pickSlotText) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement pickASlotElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pickASlotButton_Xpath));
		String getPickSlotText = pickASlotElement.getText();
		Assert.assertEquals(getPickSlotText, pickSlotText);
	}
	
	public void ensureReferralBannerText(String referralBannerText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement referralBannerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(referEarnBannerHeading_Xpath));
		String getReferralBannerText = referralBannerElement.getText();
		Assert.assertEquals(getReferralBannerText, referralBannerText);	
	}
	
	public void clickRefferalBannerDashButton() {
		driver.findElement(referEarnBannerButton_Xpath).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://code-stage.whjr.one/s/refer?utm_campaign=bdt&prev_source=trial_dashboard_banner");
	}
	
	public void ensureDashboardVideoText(String dashVideoHeading) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement dashVideoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardVideoHeading_Xpath));
		Assert.assertEquals(dashVideoElement.getText(), dashVideoHeading);
	}
	
	public void clickOnDashboardVideo() {
		WebElement youtubeDashIframe = driver.findElement(dashboardYTVideo_Xpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", youtubeDashIframe);
		driver.switchTo().frame(youtubeDashIframe);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		
		WebElement dashbYTBPauseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardYTPause_Xpath));
		dashbYTBPauseElement.click();
		
	}
	
	public void ensureStudentWebsiteHeading() {
		String studentDashName = driver.findElement(dashboardStudentName_Xpath).getText();
		String studentWebsiteBannerHeading = driver.findElement(createWebsiteHeading_Xpath).getText();
		studentWebsiteBannerHeading.contains(studentDashName);
	}
	
	public void clickOnStudentWesbiteBtn() {
		//driver.findElement(studentWebsiteButton_Xpath).click();
		WebElement studentWebSiteBtn= driver.findElement(studentWebsiteButton_Xpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentWebSiteBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement studentWebsiteBtnElement = wait.until(ExpectedConditions.elementToBeClickable(studentWebSiteBtn));
		studentWebsiteBtnElement.click();
	}
	
	public void ensureStudentWebsiteName() {
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
		
		String studentWebsiteURL = driver.getCurrentUrl();
		String studentDashName = driver.findElement(dashboardStudentName_Xpath).getText();
		studentWebsiteURL.contains(studentDashName.toLowerCase());
	}
	
	public void ensureReviewsHeading(String reviewsHeader) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		WebElement reviewsHeadingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewsHeading_Xpath));
		String reviewsHeadingText = reviewsHeadingElement.getText();
		Assert.assertEquals(reviewsHeadingText, reviewsHeader);
	}
	
	public void ensureReviewsCardCount() {
		List<WebElement> reviewsCards = driver.findElements(reviewsCards_Xpath);
		Assert.assertEquals(reviewsCards.size(), 3);
	}
	
	public void ensuretrialScheduledText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		WebElement trialScheduledTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(trialClassScheduledtext_Xpath));
		String getTrialScheduledText = trialScheduledTextElement.getText();
		//String getTrialScheduledText = driver.findElement(trialClassScheduledtext_Xpath).getText();
		System.out.println(getTrialScheduledText);
		Assert.assertEquals(getTrialScheduledText, "Trial class scheduled! ");
	}
	
	public void ensureTrialStartsText() {
		String getTrialStartsTimerText = driver.findElement(trialClassStartsTimerText_Xpath).getText();
		System.out.println(getTrialStartsTimerText);
		Assert.assertEquals(getTrialStartsTimerText, "Your class starts in");
	}
	
	public void ensureTrialScheduledClassName() {
		String getTrialStartsTimerText = driver.findElement(trialDashboardClassName_Xpath).getText();
		System.out.println(getTrialStartsTimerText);
		
	}

}
