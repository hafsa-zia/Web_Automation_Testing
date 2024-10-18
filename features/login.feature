Feature: Spotify Login

  Scenario: User logs into Spotify with valid credentials
    Given I am on the Spotify login page
    When I enter the email "hafsaz2533@gmail.com"
    And I enter the password "hafsa@2526"
    And I click the login button
    Then I should be logged in successfully
