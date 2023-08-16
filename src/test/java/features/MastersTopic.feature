Feature: Verify and Validate Masters Topic Module
  
  @TopicsListVerificationTest
	Scenario: Verify Topic List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page
   Given User Login With Valid Credentials "softwaretest1449@gmail.com" "Test@1234"
    When User Clicks on Masters Menu and Select Topic Sub Menu
    And User Search Java Technology
    Then Verify only Java Technology Appears on the Page
    
    
    @TopicsListVerificationTest
	Scenario: Verify Topic List when User Clicks on First Employee then User Will Redirect to Selected Employee Details Page
    Given User Refresh The Browser
    And User Currently is on Masters Topic Module
    When User Clicks on Add Topic button
    And User Enter All The Required Fields
    Then User Clicks on Add Topic button
    And Verify The Topic Added Successfully