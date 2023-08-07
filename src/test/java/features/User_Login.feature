Feature: Verify and Validate User Login 

  Scenario: Login with Valid data
    Given User select the browser
    When User Currently is on Login Page
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
 
  Scenario: Verify Sign In With OTP Invalid
    Given User select the browser
    And User Currently is on Login Page
    When User clicks on Sign In With OTP Link
    And Enter Invalid Email
    And Click on send OTP Btn
    And Verify The OTP Popup
    Then Close The Browser
      
  Scenario: Verify Empplyee List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Clicks on First Employee From the List
    And User Redirect To Selected Employee Detais Page
    Then Verify The Employee Detais Are The Same As Selected Employee
    Then Close The Browser
    
  Scenario: Verify User Add New Employee
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Clicks on Add Employee button
    And User Redirect To Add Employee Page
    Then User Enter Valid Employee Detais
    And User Clicks on Add Employee button
    Then Close The Browser