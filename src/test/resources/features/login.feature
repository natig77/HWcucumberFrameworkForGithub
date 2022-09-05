Feature: Login Feature

  Scenario: valid Admin Login
    Given user is on the login page
    When user enters a valid username and password
    And user clicks on login Button
    Then user is successfully logged in