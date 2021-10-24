Feature: Form tests
  As a user
  I want to test question form functionality of the site
  So that I can be sure that I can ask a question on the site correctly


  Scenario Outline: Check not correct email address message
    Given User opens '<homePage>' page
    And User clicks on News
    And User clicks on Coronavirus
    And User clicks on Your Coronavirus Stories
    And User clicks on 'What questions do you have?'
    And User checks that question form is visible
    When User enters '<text>' to the Question field
    And User enters '<name>' to the Name field
    And User enters '<number>' to the Number field
    And User enters '<location>' to the Location field
    And User accepts the Terms Of Service
    And User clicks on Submit button
    Then User checks the warning message '<expectedWarning>'

    Examples:
      | homePage             | text           | name | number     | location | expectedWarning               |
      | https://www.bbc.com/ | What is virus? | Joe  | 0991234567 | LA       | Email address can\'t be blank |

  Scenario Outline: Check empty question field message
    Given User opens '<homePage>' page
    And User clicks on News
    And User clicks on Coronavirus
    And User clicks on Your Coronavirus Stories
    And User clicks on 'What questions do you have?'
    And User checks that question form is visible
    When User enters '<name>' to the Name field
    And User enters '<email>' to the Email field
    And User enters '<number>' to the Number field
    And User enters '<location>' to the Location field
    And User accepts the Terms Of Service
    And User clicks on Submit button
    Then User checks the warning message '<expectedWarning>'

    Examples:
      | homePage             | name | email       | number     | location | expectedWarning |
      | https://www.bbc.com/ | Joe  | j@gmail.com | 0991234567 | LA       | can\'t be blank |

  Scenario Outline: Check empty email address and not accepted Terms Of Service messages
    Given User opens '<homePage>' page
    And User clicks on News
    And User clicks on Coronavirus
    And User clicks on Your Coronavirus Stories
    And User clicks on 'What questions do you have?'
    And User checks that question form is visible
    When User enters '<name>' to the Name field
    And User enters '<email>' to the Email field
    And User enters '<number>' to the Number field
    And User enters '<location>' to the Location field
    And User clicks on Submit button
    Then User checks warning messages '<emailWarning>' and '<checkboxWarning>'

    Examples:
      | homePage             | name | email       | number     | location | emailWarning    | checkboxWarning  |
      | https://www.bbc.com/ | Joe  | j@gmail.com | 0991234567 | LA       | can\'t be blank | must be accepted |