
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import paket.LoginPage;
import paket.ProductPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void wrongLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("antonioa", "antonio123");
        assertTrue(new ProductPage(driver).isLoaded());

    }
    @Test
    public void wrongLogin2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "");
        assertTrue(new ProductPage(driver).isLoaded());

    }

    @Test
    public void sucsessLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("aantonio", "walkmann");
        assertTrue(new ProductPage(driver).isLoaded());
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Martin\\Downloads\\chromedriver_win32");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
