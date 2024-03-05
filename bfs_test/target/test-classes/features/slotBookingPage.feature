Feature: Slot Booking Page Features
  
  @sbpnew 
  Scenario: TC_3_2_Verify click on Privacy policy link
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I click privacy policy link
  	Then Validate if privacy policy URL opens in new tab and has heading Privacy Policy
  	
 	@sbpnew
 	Scenario: TC_3_4_Verify that the first available date is preselected 
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	Then Validate if date is preselected
  		
  
  @sbpnew 
  Scenario: TC_3_5_Verify that user able to select the desired time slot
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I select a time slot
  	Then slot should get selected and Confirm Slot CTA should get enabled
  	
 	@sbpnew
  Scenario: TC_3_7_Verify that user able to click on timezone drop down and change the timezone
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I click on Timezone dropdown and select United Kingdom Time
  	Then Validate selected timezone is displayed
  	
 	@sbpnew
  Scenario: TC_3_8_Verify Trial booking confirmation upon clicking on Confirm Slot CTA
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I select a time slot
  	And I click on Confirm Slot CTA
  	Then Validate if user is redirected to trial success page
  	And Validate if language selection modal is shown	
  	
  @sbpnew 
  Scenario: TC_3_9_Verify the UI elements on language selection Modal
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd2@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I select a time slot
  	And I click on Confirm Slot CTA
  	Then Validate if all languages list are shown
  	And Validate if Confirm CTA is disabled
  	
  @sbpnew	
   Scenario: TC_3_18_Verify click on Create student_name Website CTA
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd3@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I select a time slot
  	And I click on Confirm Slot CTA
  	And I click on English language and confirm selection
  	And I close update information modal
  	And I click on Create student website
  	Then Validate if url contains 'whjr.site/users'
  	
  @sbpnew1
  Scenario: TC_3_19_Verify click on youtube video shown under WhiteHat Jr Class Experience section
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd4@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	And I click on Pick a Slot
  	And I select a time slot
  	And I click on Confirm Slot CTA
  	And I click on English language and confirm selection
  	And I close update information modal
  	And I click on Youtube pause video
  	Then Validate if youtube video button is paused	

  