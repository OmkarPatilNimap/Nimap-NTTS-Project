Feature: Customer Portal Login
    
  Scenario: Login with Valid data
    Given User select the browser
    When User is on NTTS login Portal
    And User enter a credential "jshankhpal41@gmail.com" "Jitesh@0987"
    Then Click on Sign in button
    And Verify the Outcome
    Then Logout

  Scenario Outline: Verify the data with invalid input
    Given User select the browser
    And User Currently is on Login Page
    When User enter valid and invalid credential <Username> <Password>
    Then Verify the Outcome

    Examples: 
      | Username  							| Password    | 
      | wrongemail@gmail.com    | Jitesh@0987 | 
      | jshankhpal41@gmail.com  | Wrong@123   |
      | 											  | Jitesh@0987 |
      | jshankhpal41@gmail.com  | 					  |
      
  