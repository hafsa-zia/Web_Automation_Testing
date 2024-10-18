package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;

import java.time.Duration;

public class loginTest {

    private static final String EMAIL = "hafsaz2533@gmail.com"; // Use environment variables for sensitive info
    private static final String PASSWORD = "hafsa@2526"; // Use environment variables for sensitive info

    public static void main(String[] args) {
        
        // Set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            
            driver.get("https://accounts.spotify.com/en/login");
            
            // Create an instance of the loginPage
            loginPage loginPage = new loginPage(driver);
            
            // Enter email and password
            loginPage.enterEmail(EMAIL); 
            loginPage.enterPassword(PASSWORD);
            
            // Click the login button
            loginPage.clickLoginButton();
            
            // Wait for the login process to complete
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> loginPage.isLoginSuccessful() || loginPage.isLoginErrorVisible());

            // Check if login was successful
            if (loginPage.isLoginSuccessful()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
