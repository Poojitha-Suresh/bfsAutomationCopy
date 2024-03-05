Feature: Trial Dashboard Page Features
  
  @tdpnew1
  Scenario: TC_4_1_Verify UI elements on the left hand details below profile name
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	Then Validate if student name is displayed
  	And Validate if text Complete the trial class to get your certificate is displayed
  	And Validate if certificate image is displayed
  	And Validate if helpdesk section has support number '02268337300'
  	And Validate if helpdesk section has support email  'support@whitehatjr.com'
  	
 @tdpnew2
  Scenario: TC_4_2_Verify UI elements on the Trial schedule card when No class scheduled
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	Then Verify if text 'Schedule your FREE trial class' is shown
  	And Verify if 'Pick a slot' CTA is shown
  	
  @tdpnew3
  Scenario: TC_4_3_Verify the refer and earn banner on dashboard
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	Then Verify if referral heading text 'Share the joy of learning!' is shown
  	And I click on Click Now button and page should be redirected to referral page
  	
  	
    @tdpnew4
  Scenario: TC_4_4_Verify the WHJR Experience video
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	Then Verify if dashboard text 'Whitehat Jr Class Experience' is shown
  	And I click on dashboard Youtube pause video
  	Then Validate if youtube video button is paused
  	
    @tdpnew5
  Scenario: TC_4_5_Verify the student website banner
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button 
  	Then Verify if student name is displayed in website banner
  	And I click on student webiste CTA
  	And Verify if URL of webiste page contains student name
  	
  @tdpnew6
  Scenario: TC_4_6_Verify the parents reviews
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button 
		Then Verify if reviews heading 'Here’s what parents have to say' is displayed
		And Verify if three review cards are displayed
 	
 @tdpnew7
  Scenario: TC_4_7_Verify UI elements on the Trial class scheduled card
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button 
		Then Verify the UI elements on trial class scheduled card
  	
  	
  	