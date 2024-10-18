package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LogoutPage;
import util.ExcelUtil;

import java.util.List;

public class LogoutTest {
    private WebDriver driver;
    private LogoutPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LogoutPage(driver);
        driver.get("https://accounts.spotify.com");
    }

    @Test
    public void testLoginAndLogout() {
        ExcelUtil excelReader = new ExcelUtil();
        List<String[]> testData = excelReader.readExcelData("path/to/your/excel/file.xlsx");

        for (String[] row : testData) {
            String action = row[0];
            String email = row[1];
            String password = row[2];

            if (action.equalsIgnoreCase("login")) {
                loginPage.enterEmail(email);
                loginPage.enterPassword(password);
                loginPage.clickLoginButton();
                assert loginPage.isLoginSuccessful();
            } else if (action.equalsIgnoreCase("logout")) {
                loginPage.clickLogout();
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
