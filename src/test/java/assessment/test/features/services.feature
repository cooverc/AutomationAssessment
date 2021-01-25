Feature: Task 2 - API Automated test using

  @TestReport
  Scenario: Get each country information
    Then I validate GET service response
    |Country|
    |US|
    |DE|
    |GB|

    ### Post Test
  @TestTBD
  Scenario: Post request for the future
    Then I validate Post service response
