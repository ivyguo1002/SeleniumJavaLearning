Feature: Application Login

  Scenario:Login
  Given I have signed in as a user
  When I log in as user
  Then I should be logged in to the system

  Scenario: Login with parameters
    Given I have signed in as a user
    When I log in with username "admin" password "admin"
    Then I should be logged in to the system


