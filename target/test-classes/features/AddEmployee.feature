Feature: Add Employee Feature
  Scenario: adding employee
    Given user is on the login page
    When user enters a valid username and password
    And user clicks on login Button
    When user clicks on PIM option
    And user clicks on add employee option
    When user enters firstName and lastName
    And user clicks on save button
    Then employee added successfully