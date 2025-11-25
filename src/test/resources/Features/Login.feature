@chrome @base
Feature: Login example

  Scenario: Login successfully
    Given Open page "https://practicetestautomation.com/practice-test-login/"
    When Enter login "student" and password "Password123"
    Then User is successfully logged in
    And Displayed login matches entered login