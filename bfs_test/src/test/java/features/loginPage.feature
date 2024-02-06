Feature: Login Page Features
  
  Scenario: TC_2_1_Verify UI elements on login page
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I stay on that page
  	Then UI elements on page should be displayed properly
  
  
  Scenario: TC_2_2_Verify by clicking on "Login with Password" button
    Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	Then UI elements on login with password page should be displayed properly
  

  Scenario: TC_2_3_Verify by clicking on "Login with PIN" button
    Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I click on Login with PIN button
  	Then I should be redirected back to login with mobile page 
  	
     
  Scenario: TC_2_10_Verify Login by entering invalid mobile number
    Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Mobile number and enter "3321111"
  	And I click on Send Verification Code button
  	Then Validate error message User not Found
  	
  Scenario: TC_2_10_Verify Login by entering invalid mobile number
    Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Mobile number and enter "3321111"
  	And I click on Send Verification Code button
  	Then Validate error message User not Found
  	
  	@lpnew
  Scenario: TC_2_12_Verify Login with valid email ID and password for existing user
  	Given I navigate to the url "https://code-stage.whjr.one/s/login"
  	When I click on Login With Password button
  	And I enter Email ID 'poojitha.suresh+autoemailpwd1@whitehatjr.com' and Password 'whitehatjr' and click on Login button
  	Then Validate user is redirected to dashboard
  	
