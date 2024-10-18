Feature: Search Functionality
@search
  Scenario: Verify that users can search for songs
    Given I am on  Spotify login page
    When I enter a song name in the search bar "Song Name"
    Then I should see a list of matching songs
    And I should be able to play any song from the results
