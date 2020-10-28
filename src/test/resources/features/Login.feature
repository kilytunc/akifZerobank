Feature: Login functionality


  Scenario Outline: Negative Login Test  <userName> / <password>
    Given the user is on the login page
    When the user enters to "<userName>" "<password>"
    Then the user should see "Login and/or password are wrong."
    Examples:
      | userName      | password   |
      | username      | wrongpasss |
      | worngname     | password   |
      |               | password   |
      |               | wrongpasss |
      | username      |            |
      | wrongusername |            |


  @wip
  Scenario: Positive login test
    Given the user is on the login page
    When the user enter with valid credentials
    Then user should successfully logged in