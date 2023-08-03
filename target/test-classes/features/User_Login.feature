Feature: Verify and Validate User Login 

  #Scenario: Login with Valid data
    #Given User select the browser
    #When User Currently is on Login Page
    #And User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    #Then Click on Sign in button
    #And Verify Login Success Outcome
    #Then Logout and close the current browser
#
  #Scenario Outline: Verify the data with invalid input
    #Given User select the browser
    #And User Currently is on Login Page
    #When User enter valid and invalid credential <Username> <Password>
    #And Verify the Outcome Fail
    #Then Close The Browser 
#
    #Examples: 
      #| Username  					    		| Password    | 
      #| wrongemail@gmail.com 		    | Test@1234   | 
      #| softwaretest1449@gmail.com  | Wrong@123   |
      #
  #Scenario: Verify the forgot password link
    #Given User select the browser
    #And User Currently is on Login Page
    #When User clicks on forgot password link
    #And Enter Email
    #And Click on send OTP Btn
    #And Verify The OTP Popup
    #And User Enter Invalid OTP and New Password
    #And Verify OTP Message
    #Then Close The Browser
    #
  #Scenario: Verify Sign In With OTP
    #Given User select the browser
    #And User Currently is on Login Page
    #When User clicks on Sign In With OTP Link
    #And Enter Email
    #And Click on send OTP Btn
    #And Verify The OTP Popup
    #And User Enter InValid OTP 
    #And Verify OTP Message
    #Then Close The Browser
 #------------------------------------------------------------
 #
   #Scenario: Verify Dashboard Calander With Start Date and End Date
    #Given User select the browser
    #When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    #Then User Clicks on Dashboard Menu 
    #And  User Select Highlited Date as a Start Date in Calander
    #And User Select Today as an End Date in Calander
    #Then Close The Browser
        #
    #Scenario: Edit Calander With New Start Date and New End Date
    #Given User select the browser
    #When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    #When User Clicks on Dashboard Menu
    #And User Select Previous Month Date as a Start Date in Calander
    #Then User Select Today as an End Date in Calander
    #Then Close The Browser
    #
    #Scenario: Verify Dashboard Calander Invalid Scenario
    #Given User select the browser
    #When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    #And User Clicks on Dashboard Menu
    #Then User Select Highlited Date as a Start Date in Calander
    #And User Select End Date Before Start Date in Calander
    #Then Close The Browser
    
    Scenario: Verify Top Rating Menu
    Given User select the browser
    When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    When User Clicks on Dashboard Menu
    And User Select Highlited Date as a Start Date in Calander
    Then User Select Today as an End Date in Calander
    And User Clicks on Top Rating Menu
    Then Verify Employee Records Sorted With Highest Rating at Top and Lowest Rating at Bottom
    Then Close The Browser
     