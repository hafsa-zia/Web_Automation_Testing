package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage2 {
    private WebDriver driver;

    public loginPage2(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://www.spotify.com/login"); // URL of the login page
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("login-username")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("login-password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }
}
