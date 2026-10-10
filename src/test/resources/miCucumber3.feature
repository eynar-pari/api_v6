Feature: Login

  Background:
    Given I have access to facebook

  Scenario: As User I want to use my email and password so that login in the app
    When I enter my email: fake@fake.com
    And I enter my password: 98789456
    Then I "should" be logged in successfully


  Scenario: As User I want to use my email and password so that login in the app
    When I enter my email: fake@fake.com
    Then I "should not" be logged in successfully


  Scenario: As User I want to use my email and password so that login in the app
    And I enter my password: 98789456
    Then I "should not" be logged in successfully