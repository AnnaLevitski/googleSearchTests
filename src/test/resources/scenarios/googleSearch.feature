Feature: google search tests

  Background: open site
    Given open "https://www.google.com/"

  Scenario:
    When Enter the search "ok google"
    And Press the search button
    Then Checking the results contains "Google Assistant"
    Then Checking that the number of search results is greater than 10

  Scenario:
    When Enter the search "-_-"
    And Press the search button
    Then Checking the results contains "-_-"
    Then Checking that the number of search results is greater than 10