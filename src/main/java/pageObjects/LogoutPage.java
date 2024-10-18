package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
public class LogoutPage {

	    private WebDriver driver;

	    // Locators
	    private By emailField = By.id("login-username");
	    private By passwordField = By.id("login-password");
	    private By loginButton = By.xpath("//*[@id='login-button']/span[1]/span");
	    private By profileName = By.id("profile-name");
	    private By errorMessage = By.className("error-message");
	    
	    // New locators for Logout
	    private By profileMenu = By.id("profile-menu"); // Locator for the profile menu
	    private By logoutButton = By.id("logout-button"); // Locator for the logout button

	    public LogoutPage(WebDriver driver) {
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
	            return true;
	        } catch (TimeoutException e) {
	            System.out.println("Profile name was not visible within the timeout period.");
	            return false;
	        }
	    }

	    public boolean isLoginErrorVisible() {
	        try {
	            return driver.findElements(errorMessage).size() > 0;
	        } catch (TimeoutException e) {
	            System.out.println("Error message was not visible within the timeout period.");
	            return false;
	        }
	    }

	    // New method to log out
	    public void clickLogout() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        try {
	            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(profileMenu));
	            menu.click();
	            WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
	            logout.click();
	        } catch (TimeoutException e) {
	            System.out.println("Logout failed within the timeout period.");
	        }
	    }
	}



