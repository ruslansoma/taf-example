Feature: Github login

  @ui
  Scenario Template: User should see error message after login with invalid credentials
    Given user opens Github main page
    When user click Sign in button
    And user logins with "<login>" and "<password>"
    Then user sees error message "Incorrect username or password."

    Examples:
      | login                 | password        |
      | ruslansoma            | qwerty1234&     |
      | wronglogin@github.com | someanotherpass |