Feature: Login
  @Regression @SmokeTest @Priority1
  Scenario Outline: As User I want to use my email and password so that login in the app

    Given I have access to facebook
    When I enter my email: <email>
    And I enter my password: <password>
    Then I "should" be logged in successfully

    Examples:
    |email| password|
    |fake@fake.com| 12345|
    |fake1@fake.com| 54321|
    |fake2@fake.com| 56777|


