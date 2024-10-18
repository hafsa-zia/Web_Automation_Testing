package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String songName) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300)); // Wait up to 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='search-input']")));
        driver.findElement(By.cssSelector("input[data-testid='search-input']")).sendKeys(songName);
    }

    public List<String> getDisplayedSearchResults() {
        return driver.findElements(By.className("song-result")) // Adjust selector as necessary
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public void playSong(String songName) {
        driver.findElement(By.xpath("//div[text()='" + songName + "']")).click(); // Adjust selector as necessary
    }

    public boolean isSongPlaying(String songName) {
        // Logic to verify if the song is currently playing
        // For example, check if the player displays the song name
        return driver.findElement(By.id("currently-playing")).getText().equals(songName); // Adjust selector as necessary
    }
}
