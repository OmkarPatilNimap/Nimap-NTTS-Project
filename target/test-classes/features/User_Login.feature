Feature: Customer Portal Login
    
  Scenario: Login with Valid data
    Given User select the browser
    When User is on NTTS login Portal
    And User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    Then Click on Sign in button
    And Verify Login Success Outcome
    Then Logout and close the current browser

  Scenario Outline: Verify the data with invalid input
    Given User select the browser
    And User Currently is on Login Page
    When User enter valid and invalid credential <Username> <Password>
    And Verify the Outcome Fail
    Then Close The Browser 

    Examples: 
      | Username  					    		| Password    | 
      | wrongemail@gmail.com 		    | Test@1234   | 
      | softwaretest1449@gmail.com  | Wrong@123   |
      
  Scenario: Verify the forgot password link
    Given User select the browser
    And User Currently is on Login Page
    When User clicks on forgot password link
    And Enter Email
    And Click on send OTP Btn
    And Verify The OTP Popup
    And User Enter Invalid OTP and New Password
    And Verify OTP Message
    Then Close The Browser
    
   Scenario: Verify Sign In With OTP
    Given User select the browser
    And User Currently is on Login Page
    When User clicks on Sign In With OTP Link
    And Enter Email
    And Click on send OTP Btn
    And Verify The OTP Popup
    And User Enter InValid OTP 
    And Verify OTP Message
    Then Close The Browser
    
    Scenario: Verify Dashboard Calander
    Given User select the browser
    And User Currently is on Login Page
    And User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    Then Click on Sign in button
    When User Clicks on Dashboard Menu
    And  User Select Current Date as Start Date in Calander
    And User Select Next Date as End Date in Calander
    Then Close The Browser
    
   