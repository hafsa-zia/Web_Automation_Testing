package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException; // Import the TimeoutException class

import java.time.Duration;

public class loginPage {

    private WebDriver driver;

    // Locators
    private By emailField = By.id("login-username"); // Adjust based on actual ID or selector
    private By passwordField = By.id("login-password"); // Adjust based on actual ID or selector
    private By loginButton = By.xpath("//*[@id='login-button']/span[1]/span"); // Adjust based on actual XPath
    private By profileName = By.id("profile-name"); // Adjust based on the actual ID for the profile element
    private By errorMessage = By.className("error-message"); // Adjust based on the actual class for error messages

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            button.click();
        } catch (TimeoutException e) {
            System.out.println("Login button was not clickable within the timeout period.");
        }
    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileName));
            return true; // Login successful if profile name is visible
        } catch (TimeoutException e) {
            System.out.println("Profile name was not visible within the timeout period.");
            return false; // Return false if profile name is not visible
        }
    }

    public boolean isLoginErrorVisible() {
        try {
            return driver.findElements(errorMessage).size() > 0; // Check if error message is present
        } catch (TimeoutException e) {
            System.out.println("Error message was not visible within the timeout period.");
            return false;
        }
    }
}
