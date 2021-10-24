Feature: Articles
  As a user
  I want to test names of articles of the site
  So that I can be sure that site displays information correctly

  Scenario Outline: Check the name of the headline article
    Given User opens '<homePage>' page
    When User clicks on News
    Then User checks the name of the headline article equals to '<expectedName>'

    Examples:
      | homePage             | expectedName                               |
      | https://www.bbc.com/ | Colombia\'s most wanted drug lord captured |


  Scenario Outline: Check the name of secondary articles
    Given User opens '<homePage>' page
    When User clicks on News
    Then User checks that names of secondary articles equal to the following:
      | Injured filmmaker 'gutted' at movie set death      |
      | Picasso works fetch nearly $110m in Las Vegas sale |
      | Superfan finally enjoys 6,000th rollercoaster ride |
      | Gravedigger's love story wins African film prize   |
      | UK textbook pulled over Native American question   |

    Examples:
      | homePage             |
      | https://www.bbc.com/ |


  Scenario Outline: Check the name category link
    Given User opens '<homePage>' page
    When User clicks on News
    And User enters the Category link of the headline article in the Search bar
    Then User checks the name of the first article equals to '<expectedName>'

    Examples:
      | homePage             | expectedName                                                   |
      | https://www.bbc.com/ | Later... with Jools Holland: Series 59: Sting and Nubya Garcia |
