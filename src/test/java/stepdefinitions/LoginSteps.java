package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    LoginPage loginPage;  // declare only, don't initialize here

    @Before
    public void setUp() {
        DriverManager.initDriver();           // initialize the driver first
        loginPage = new LoginPage(DriverManager.getDriver()); // now it's safe
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("I open the login page")
    public void openLoginPage() { loginPage.open(); }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @And("I click Submit")
    public void clickSubmit() { loginPage.clickSubmit(); }

    @Then("I should be logged in successfully")
    public void verifyLogin() {
        String url = loginPage.getCurrentUrl();
        Assert.assertTrue(url.contains("logged-in-successfully"));
    }
}