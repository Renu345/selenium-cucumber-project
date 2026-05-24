package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By submitButton  = By.id("submit");
    By errorMessage  = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}