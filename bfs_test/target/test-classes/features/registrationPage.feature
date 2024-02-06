
Feature: Registration Page Features
  
  @sanity
 Scenario: TC_1_1_Verify launch of registration page and redirection of URL from coding to mastery for India user
 	Given I navigate to the url "https://code-stage.whjr.one/trial/register"
 	Then Validate that I am redirected to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 
 @sanity
 Scenario: TC_1_2_Verify launch of registration page and redirection of URL from coding to mastery for India user
 	Given I navigate to the url "https://code-stage.whjr.one/coding/trial/register"
 	Then Validate that I am redirected to the url "https://code-stage.whjr.one/coding/mastery/trial/register?courseType=coding"
  @sanity
 Scenario: TC_1_3_Verify launch of mastery registration page for India user
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	Then Validate that I am redirected to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 @sanity
 Scenario: TC_1_4_erify the UI elements on registration page for India
 	 Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	 Then Validate the UI Elements of the Registration Page for India
  @sanity
 Scenario: TC_1_5_Verify entering of invalid 8 or 11 digit phone number for India region
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "15362534"
 	And I click outside the phone number field
 	Then Error message Enter a valid mobile number should be displayed
 	
 @sanity
 Scenario: TC_1_6_Verify entering of valid 10 digit phone number for India region
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253629"
 	Then A tick mark should appear after the 10 digit mobile number
 	
 @sanity
 Scenario: TC_1_7_Verify selection on grade bucket
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I select grade "3"
 	Then Selected grade bucket should be highlighted with Orange colour
 
 #TC_1_8 is related to Captcha Validation, hence not automated
 
  #@sanity
 Scenario: TC_1_9_Verify if click on Terms & Condition opens the URL in a new tab for India users
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I click on Terms & Condition link
 	Then A new tab should open with url:"https://code-stage.whjr.one/terms-conditions" and heading "Terms & Conditions"
 	
 @sanity
 Scenario: TC_1_10_Verify registeration without grade selection
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253625" and click on Schedule Now CTA button
 	Then Error message Childs Grade is required should be displayed
 	
 @sanity
 Scenario: TC_1_11_Verify Schedule Now CTA click once all the fields are filled in
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
		When I enter the phone number "2536253625" and select grade "3"
		Then Ensure CTA button is enabled
		
 @sanity
 Scenario: TC_1_12_Verify OTP screen UI
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253629" and select grade "3" and click on schedule now button
 	Then OTP modal with proper details and mobile number "2536253629" should be displayed
 	@otp_13
 Scenario: TC_1_13_Verify entering valid 4 digit OTP
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253629" and select grade "3" and click on schedule now button
 	And I enter the OTP received on mobile number "2536253629"
 	Then Validate that I am redirected to the url "https://code-stage.whjr.one/s/coding/mastery/trial/schedule"
 	
 @sanity	
 Scenario: TC_1_14_Verify entering of invalid 4 digit OTP
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253625" and select grade "3" and click on schedule now button
 	And I enter invalid OTP
 	Then Error msg should be displayed on OTP Modal Popup
 	@sanity
 Scenario: TC_1_15_Verify Resend Via call success message
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253629" and select grade "3" and click on schedule now button
 	And I click on Resend via call
 	Then Validate text OTP has been sent
 	
 @sanity
 Scenario: TC_1_16_Verify via SMS
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253629" and select grade "3" and click on schedule now button
 	And I click on Resend via SMS
 	Then Validate text OTP has been sent
 	
 @sanity
 Scenario: TC_1_18_Verify closing OTP popup
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "2536253629" and select grade "3" and click on schedule now button
 	And Close the OTP Popup
 	Then Validate that the OTP Pop-up is closed
 	
 @sanity	
	Scenario: TC_1_17_Verify closing OTP popup
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "3525534423" and select grade "3"
 	Then Validate that the OTP Pop-up for registered user "3525534423"	
  @sanity
 Scenario: TC_1_19_Verify Resend CTA click on OTP modal for already registered user
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
		When I enter the phone number "3525534433" and select grade "3" and click on schedule now button
		And I click on Resend via SMS
		Then Validate text OTP has been sent
 	
 @otp
 Scenario Outline: TC_1_20_TO_23_Verify entering valid 4 digit OTP
 	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
 	When I enter the phone number "<mob no>" and select grade "3"
 	And I enter the OTP received on mobile number "<mob no>"
 	Then Validate that I am redirected to the url "<red_url>"
  Examples:
 |mob no|red_url|
 |3525534423|https://code-stage.whjr.one/s/coding/mastery/trial/schedule|
 |3525534423|https://code-stage.whjr.one/s/dashboard|
 |2983774655|https://code-stage.whjr.one/s/dashboard|
 |3880008191|https://learn-stage.whjr.one/coding/dashboard/classes|
 
 
 
 
   #Scenario: TC_1_12_Verify OTP screen UI
  #	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
  #	When I enter the phone number "2536253625" and select grade "3" and click on schedule now button
  #	Then OTP modal with proper details and mobile number "2536253625" should be displayed
  #
  #
    #@new	
  #Scenario: TC_1_13_Verify entering valid 4 digit OTP
  #	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
  #	When I enter the phone number "2536253625" and select grade "3" and click on schedule now button
  #	And I enter the OTP received on mobile number "2536253625"
  #	Then Validate that I am redirected to the url "https://code-stage.whjr.one/s/coding/mastery/trial/schedule"
  #	
  #	
  #Scenario: TC_1_14_Verify entering of invalid 4 digit OTP
  #	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
  #	When I enter the phone number "2536253625" and select grade "3" and click on schedule now button
  #	And I enter invalid OTP 
  #	Then Error msg should be displayed on OTP Modal Popup
  #
  #	
  #Scenario: TC_1_15_Verify Resend Via call success message
  #	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
  #	When I enter the phone number "2536253625" and select grade "3" and click on schedule now button
  #	And I click on Resend via call
  #	Then Validate text OTP has been sent
  #	
  #
  #Scenario: TC_1_16_Verify via SMS
  #	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
  #	When I enter the phone number "2536253625" and select grade "3" and click on schedule now button
  #	And I click on Resend via SMS
  #	Then Validate text OTP has been sent
  #	
  #Scenario Outline: TC_1_20_TO_23_Verify entering valid 4 digit OTP
  #	Given I navigate to the url "https://code-stage.whjr.one/coding/mastery/trial/register"
  #	When I enter the phone number "<mob no>" and select grade "3"
  #	And I enter the OTP received on mobile number "<mob no>"
  #	Then Validate that I am redirected to the url "<red_url>"
  #
  #Examples:
  #|mob no|red_url|
  #|3525534423|https://code-stage.whjr.one/s/coding/mastery/trial/schedule|
  #|3525534423|https://code-stage.whjr.one/s/dashboard|
  #|2983774655|https://code-stage.whjr.one/s/dashboard|
  #|3880008191|https://learn-stage.whjr.one/coding/dashboard/classes|
  #	
  #	
  
  