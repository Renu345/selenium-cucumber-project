Feature: Login functionality

  Scenario: Positive login test
    Given I open the login page
    When I enter username "student" and password "Password123"
    And I click Submit
    Then I should be logged in successfully