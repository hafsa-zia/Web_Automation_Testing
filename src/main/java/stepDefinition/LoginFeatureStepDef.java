package stepDefinition;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFeatureStepDef {

	    WebDriver driver;
	    pageObjects.loginPage loginPage;

	    @Given("I am on the Spotify login page")
	    public void i_am_on_the_spotify_login_page() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://accounts.spotify.com/en/login");
	        loginPage = new pageObjects.loginPage(driver);
	    }

	    @When("I enter the email {string}")
	    public void i_enter_the_email(String email) {
	        loginPage.enterEmail(email);
	    }

	    @When("I enter the password {string}")
	    public void i_enter_the_password(String password) {
	        loginPage.enterPassword(password);
	    }

	    @When("I click the login button")
	    public void i_click_the_login_button() {
	        loginPage.clickLoginButton();
	    }

	    @Then("I should be logged in successfully")
	    public void i_should_be_logged_in_successfully() {
	        if (loginPage.isLoginSuccessful()) {
	            System.out.println("Login successful!");
	        } else {
	            System.out.println("Login failed!");
	        }
	        assertTrue(loginPage.isLoginSuccessful());
	        driver.quit();
	    }
	}

