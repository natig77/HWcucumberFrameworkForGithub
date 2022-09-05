package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;

public class AddEmployeeSteps extends CommonMethods {
    @Given("user is on the login page")
    public void start(){
        openBrowserAndLaunchApplication();
    }
    @When("user enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
        login.usernameTextField.sendKeys(ConfigReader.getPropertyValue("username"));
        login.passwordTextField.sendKeys(ConfigReader.getPropertyValue("password"));
    }
    @And("user clicks on login Button")
    public void user_clicks_on_login_button() {
        login.loginButton.click();
    }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //   DashboardPage dash = new DashboardPage();
        click(dash.pimOption);
    }
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        click(dash.addEmployeeOption);
    }
    @When("user enters firstName and lastName")
    public void user_enters_first_name_and_last_name() {
        sendText(addEmployeePage.firstName, "Natig");
        sendText(addEmployeePage.lastName, "Gurbanov");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        //homework - verify added employee
        System.out.println("Employee added");
    }
}
