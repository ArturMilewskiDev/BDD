Feature: Login screen

  Scenario: Login screen is displayed
    When launch login screen
    Then title "Login" is displayed
    And should see email input
    And should see password input
    And button with text "Submit" is displayed

  Scenario Outline: Type email and password in incorrect format
    When launch login screen
    When type email "<email>"
    And type password "<password>"
    And hide keyboard
    And click option with text "Submit"
    Then should <see email error> email error
    And should <see password error> password error

    Examples:
      | email                 | password | see email error | see password error |
      | incorrect email       | password | true            | false              |
      | incorrect email       |          | true            | true               |
      |                       |          | true            | true               |
      | validformat@email.com |          | false           | true               |

  Scenario Outline: Auth error is displayed
    When launch login screen
    And type email "<email>"
    And type password "<password>"
    And hide keyboard
    And click option with text "Submit"
    Then should see auth error

    Examples:
      | email             | password        |
      | valid@email.com   | invalidpassword |
      | invalid@email.com | validpassword   |
      | invalid@email.com | invalidpassword |

  @Android
  Scenario: Only Android Scenario
    When when Android stuff
    Then then Android stuff

  @iOS
  Scenario: Only iOS Scenario
    When when iOS stuff
    Then then iOS stuff

  @intents
  Scenario: Log in completed successfully
    When launch login screen
    And type email "valid@email.com"
    And type password "validpassword"
    And hide keyboard
    And click option with text "Submit"
    Then should see homepage screen