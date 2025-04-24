@googleSearch
Feature: Google search functionality
  Agile story: As a user, When I am on the Google search page
  I should be able to search anything and see relevant results

  Scenario: Search page default title verification
    When user is on the Google search
    Then user should see title is Google

Scenario: Search for a keyword
  When user is on the Google search
  Then user enters "selenium" in the search box and clicks enter
  Then actual title should contain the searched term "selenium"