Feature: Verify and Validate Masters Employee

#		@EmployeeListVerificationTest
#	Scenario: Verify Empplyee List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page
   #Given User select the browser
    #And User Currently is on Login Page
    #When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    #And Click on Sign in button
    #And User Clicks on Masters Menu and Select Employee Sub Menu
    #Then Open Employee List Page
    #And User Clicks on First Employee From the List
    #And User Redirect To Selected Employee Detais Page
    #Then Verify The Employee Detais Are The Same As Selected Employee
    #Then Close The Browser
    #
    #@EmployeeListVerificationTest
#	Scenario: Verify Empplyee List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page
   #Given User select the browser
    #And User Currently is on Login Page
    #When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    #And Click on Sign in button
    #And User Clicks on Masters Menu and Select Employee Sub Menu
    #Then Open Employee List Page
    #And User Clicks on Active Employee Slider
    #Then User Scroll Down and Clicks on Show First 25 Entries
    #And User Scroll Up and Verify The 25 Rows Are Loaded in Employee List
    #Then Close The Browser
    #
     #@EmployeeListVerificationTest
#	Scenario: Verify Empplyee List when User Clicks on Active Employee Slider and User Verify Existing Employee is Available in List
   #Given User select the browser
    #And User Currently is on Login Page
    #When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    #And Click on Sign in button
    #And User Clicks on Masters Menu and Select Employee Sub Menu
    #Then Open Employee List Page
    #And User Clicks on Active Employee Slider
    #Then User Type Existing Employee Name and Click on Search button
    #And Only one Search Entry is Available Verify the Actual Searched Name With Available Employee Search Name
    #Then Close The Browser
    
    @EmployeeListVerificationTest  
  Scenario: Verify when User Add New Employee
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
    
    @EmployeeListVerificationTest
  Scenario: Verify when User Apply Filter Condition
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
    
    @EmployeeListVerificationTest
  Scenario: Verify User Can Edit and Save Employee Details
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Search Newly Added Employee
    And User Clicks on Edit Employee Details button
    And User Edits Few Fields
    Then User Clicks on Edit Employee button and save the Details
    And User Verify Employee Details Edited Successfully
    Then Close The Browser
    
    @EmployeeListVerificationTest
  Scenario: Verify User Can Search, Delete Employee, and Verify Employee Deleted Successfully
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Search Newly Edited Employee Name
    And User Clicks on Delete Employee button
    And User Search Newly Added Employee and Verify Employee Deleted Successfully
   Then Close The Browser
   
   @EmployeeListVerificationTest
	Scenario: Verify Empplyee List when User Clicks on Deleted Employee Slider and User Verify Deleted Employee Name is Available in List
   Given User select the browser
    And User Currently is on Login Page
    When User enter a credential "softwaretest1449@gmail.com" "Test@1234"
    And Click on Sign in button
    And User Clicks on Masters Menu and Select Employee Sub Menu
    Then Open Employee List Page
    And User Clicks on Deleted Employee Slider
    Then User Type Recently Deleted Employee Name and Click on Search button
    And Verify Search Entry is Available in Deleted Employee Page Verify the Actual Searched Name With Available Employee Search Name
    Then Close The Browser
    