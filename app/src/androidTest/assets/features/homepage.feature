Feature: Homepage screen

  Scenario: Homepage screen is displayed
    When launch homepage screen
    Then title "Homepage" is displayed
    And users are displayed
      | name  | surname  | premiumAccount | age | additionalInformation |
      | John  | Kowalsky | true           | 30  |                       |
      | Linda | Smith    | false          | 40  | Lorem ipsum           |
   And button with text "Logout" is displayed

  @intents
  Scenario: Tap logout button and show login screen
    When launch homepage screen
    When click option with text "Logout"
    Then should see login screen

