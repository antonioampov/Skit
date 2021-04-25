package paket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://forum.carclub.mk/");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("input_text"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.className("input_text")).clear();
        driver.findElement(By.className("input_text")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.className("input_password")).sendKeys(password);
        Thread.sleep(5000);


    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.className("error"));
        return errorPage.getText();
    }
}

