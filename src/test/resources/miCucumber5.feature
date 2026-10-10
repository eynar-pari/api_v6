Feature: Login
  @Regression @SmokeTest @Priority1
  Scenario: As User I want to use my email and password so that login in the app

    Given I have access to facebook
    When I enter my email: fake@fake.com
    And I enter my password: 98789456
    Then I "should" be logged in successfully
    And the message should be displayed
    """
    Login successfully
    Welcome...
    fage@fake.com
    date 10/10/2026
    last login 10/10/2026
    """

