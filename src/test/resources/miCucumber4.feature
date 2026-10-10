Feature: Login
  Rule: The user needs email format
  Scenario: As User I want to use my email and password so that login in the app

    Given I have access to facebook
    When I enter my email: fake@fake.com
    And I enter my password: 98789456
    Then I "should" be logged in successfully

    Scenario: As User I want to use my email and password so that login in the app
# this is a comment
      Given I have access to facebook
      When I enter my email: fake@fake.com
      And I enter my password: 98789456
      Then I "should" be logged in successfully
