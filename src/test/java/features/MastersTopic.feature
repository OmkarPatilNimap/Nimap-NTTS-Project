Feature: Verify and Validate Masters Topic Module
    
  Background:
    Given User Login With Valid Credentials "softwaretest1449@gmail.com" "Test@1234"
 		When User Clicks on Masters Menu and Select Topic Sub Menu
 		
  @TopicsListVerificationTest @Regression
	Scenario: Verify Topic List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page 
    When User Search Java Technology
    And Verify only Java Technology Appears on the Page
    Then Close The Browser
    
  @TopicsListVerificationTest @Smoke
	Scenario: Verify Topic List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page
    And User Currently is on Masters Topic Module
    When User Clicks on Add Topic button
    And User Enter All The Required Fields
    Then User Clicks on Add New Topic button
    And Verify The Topic Added Successfully
		Then Close The Browser