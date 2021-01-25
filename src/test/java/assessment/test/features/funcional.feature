Feature: Task 1 - UI Automated test using Selenium WebDriver

  Background:
    Given Go to TestSite

  @TestReport
  Scenario: Register a new user successfully
    When Click Sign in link
    And Fill a valid email
    And Click Create an Account button
    And Fill the Registration information
    And Click Register button
    Then Validate user is logged