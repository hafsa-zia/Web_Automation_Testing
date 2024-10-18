package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By profileIcon = By.id("profile-name");
    By logoutButton = By.xpath("//button[contains(text(),'Log Out')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileIcon() {
        driver.findElement(profileIcon).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
