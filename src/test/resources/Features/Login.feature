@chrome @base
Feature: Login example

  @positive
  Scenario: Login successfully
    Given Open page "https://practicetestautomation.com/practice-test-login/"
    When Enter login "student" and password "Password123" and click login button
    Then User is successfully logged in
    And Displayed login matches entered login

  @positive
  Scenario: Logout successfully
    Given Open page "https://practicetestautomation.com/practice-test-login/"
    And Enter login "student" and password "Password123" and click login button
    And User is successfully logged in
    And Displayed login matches entered login
    When Click Logout button
    Then Login page is displayed

  @negative
  Scenario: User with wrong username cannot login
    Given Open page "https://practicetestautomation.com/practice-test-login/"
    When Enter login "incorrect" and password "Password123" and click login button
    Then Verify that error message is "Your username is invalid!"

  @negative
  Scenario: User with wrong password cannot login
    Given Open page "https://practicetestautomation.com/practice-test-login/"
    When Enter login "student" and password "incorrect" and click login button
    Then Verify that error message is "Your password is invalid!"