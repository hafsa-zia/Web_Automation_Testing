package stepDefinition;
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogoutPage;
import util.ExcelUtil;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LogOutFeatureStepDef {

    private LogoutPage logoutPage;

    public LogOutFeatureStepDef() {
        this.logoutPage = new LogoutPage(BaseTest.getDriver()); // Initialize LogoutPage object with the driver from BaseTest
    }

    @Given("^I have launched the browser and navigated to the Spotify login page$")
    public void i_have_launched_the_browser_and_navigated_to_the_spotify_login_page() {
        // Code to launch the browser and navigate to the Spotify login page
        BaseTest.getDriver().get("https://www.spotify.com/login"); // Replace with actual URL
    }

    @When("^I click the profile menu$")
    public void i_click_the_profile_menu() {
        // You can call the method to log out here (splitting profile menu click and logout click for clarity)
        logoutPage.clickLogout();
    }

    @Then("^I should be logged out successfully$")
    public void i_should_be_logged_out_successfully() {
        // After logging out, verify if the user is logged out
        boolean isLoggedOut = logoutPage.isLoginErrorVisible();  // You could also verify if the user is on the login page
        assertTrue("Logout was not successful!", isLoggedOut);
    }

    @When("^I read the logout steps from Excel$")
    public void i_read_the_logout_steps_from_excel() throws Exception {
        // Path to Excel file
        String filePath = "C:\\Users\\hafsa\\eclipse-workspace\\testData.xlsx"; // Update with actual file path
        ExcelUtil excelUtil = new ExcelUtil();
        List<String[]> data = excelUtil.readExcelData(filePath);

        // Assuming first row contains "action", "email", and "password"
        // Example: ["login", "user@example.com", "password123"]
        for (String[] row : data) {
            String action = row[0];
            String email = row[1];
            String password = row[2];

            if ("login".equalsIgnoreCase(action)) {
                // Perform login before logout
                logoutPage.enterEmail(email);
                logoutPage.enterPassword(password);
                logoutPage.clickLoginButton();
            } else if ("logout".equalsIgnoreCase(action)) {
                // Call logout directly
                logoutPage.clickLogout();
            }
        }
    }
}
