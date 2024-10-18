

Feature: Logout from the Spotify website


  Background:
    Given I have launched the browser and navigated to the Spotify login page
@logout
 
  Scenario: Successful Logout after Login using Excel data
    When I read the logout steps from Excel
    Then I should be logged out successfully
 
