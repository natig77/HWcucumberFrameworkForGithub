package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {
    @Given("user is on the login page")
    public void start(){
        openBrowserAndLaunchApplication();
    }
    @When("user enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
        login.usernameTextField.sendKeys(ConfigReader.getPropertyValue("username"));
        login.passwordTextField.sendKeys(ConfigReader.getPropertyValue("password"));
    }
    @When("user clicks on login Button")
    public void user_clicks_on_login_button() {
        login.loginButton.click();
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("Test passed");
        // closeBrowser();
    }
}
