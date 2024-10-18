package stepDefinition;
import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pageObjects.loginPage2;
import pageObjects.SearchPage;
import util.DatabaseUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SearchFunctionalityStepDef {
    private loginPage2 loginPage;
    private SearchPage searchPage;
    private DatabaseUtil databaseUtil;
    private List<String> expectedResults;

    public SearchFunctionalityStepDef() {
        this.loginPage = new loginPage2(BaseTest.getDriver());
        this.searchPage = new SearchPage(BaseTest.getDriver());
        this.databaseUtil = new DatabaseUtil();
    }

    @Given("^I am on  Spotify login page$")
    public void i_am_on_the_spotify_login_page() {
        loginPage.navigateToLoginPage(); // Method to navigate to the login page
        loginPage.enterEmail("hafsaz2533@gmail.com"); // Replace with valid email
        loginPage.enterPassword("hafsa@2526"); // Replace with valid password
        loginPage.clickLoginButton(); // Method to perform login
        
    }

    @When("^I enter a song name in the search bar \"([^\"]*)\"$")
    public void i_enter_a_song_name_in_the_search_bar(String songName) {
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increase wait time
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='search-input']"))); // Wait for search bar
        searchPage.enterSearchTerm(songName); // Method to enter the search term
        expectedResults = databaseUtil.searchSongs(songName); // Fetch matching songs from the database
    }

    @Then("^I should see a list of matching songs$")
    public void i_should_see_a_list_of_matching_songs() {
        List<String> displayedResults = searchPage.getDisplayedSearchResults(); // Method to get displayed results from the UI
        Assert.assertTrue("Expected results not displayed", displayedResults.containsAll(expectedResults));
    }

    @Then("^I should be able to play any song from the results$")
    public void i_should_be_able_to_play_any_song_from_the_results() {
        String firstSong = expectedResults.get(0);
        searchPage.playSong(firstSong); // Method to play the song
        Assert.assertTrue("Song is not playing", searchPage.isSongPlaying(firstSong)); // Verify if the song is playing
    }
}