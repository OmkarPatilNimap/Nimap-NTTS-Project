Feature: Verify and Validate Masters Employee

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
    Then User Enter Valid Employee Details
    And User Clicks on Add New Employee button
    Then Close The Browser
    
    Scenario: Verify User Apply Filter Condition
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Clicks on Filter button
    And User Select Filter By Gender and Filter By Status
    Then User Clicks on Submit Filter button
    And User Verify the Filter Condition is Apply as per inputs Provided
    Then Close The Browser
    
    Scenario: Verify User Can Edit and Save Employee Details
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Clicks on Edit Employee Details button
    And User Edits Few Fields
    Then User Clicks on Edit Employee button and save the Details
    And User Verify Employee Details Edited Successfully
    Then Close The Browser