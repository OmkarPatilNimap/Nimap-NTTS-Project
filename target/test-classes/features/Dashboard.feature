Feature: Dashboard Module

   Scenario: Verify Dashboard Calander With Start Date and End Date
    Given User select the browser
    When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    Then User Clicks on Dashboard Menu 
    And  User Select Highlited Date as a Start Date in Calander
    And User Select Today as an End Date in Calander
    Then Close The Browser
        
    Scenario: Edit Calander With New Start Date and New End Date
    Given User select the browser
    When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    When User Clicks on Dashboard Menu
    And User Select Previous Month Date as a Start Date in Calander
    Then User Select Today as an End Date in Calander
    Then Close The Browser
    
    Scenario: Verify Dashboard Calander Invalid Scenario
    Given User select the browser
    When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    And User Clicks on Dashboard Menu
    Then User Select Highlited Date as a Start Date in Calander
    And User Select End Date Before Start Date in Calander
    Then Close The Browser
    
    Scenario: Verify user at Top Rating Menu clicks on the First Employee Name
    Given User select the browser
    When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    When User Clicks on Dashboard Menu
    And User Select Highlited Date as a Start Date in Calander
    Then User Select Today as an End Date in Calander
    And User Clicks on Top Rating Menu
    Then User clicks on First Employee Name
    And User Redirect to Selected Employee Details Page
    Then Close The Browser
    
    Scenario: Verify Top Rating Menu
    Given User select the browser
    When User is on Home Page "softwaretest1449@gmail.com" "Test@1234"
    When User Clicks on Dashboard Menu
    And User Select Highlited Date as a Start Date in Calander
    Then User Select Today as an End Date in Calander
    And User Clicks on Top Rating Menu
    Then Verify Employee Records Sorted With Highest Rating at Top and Lowest Rating at Bottom
    Then Close The Browser
     