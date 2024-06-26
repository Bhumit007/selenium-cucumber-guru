package StepDefinitions;

import Base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import WebAction.WebActions;

public class LoginSteps extends BaseClass {

    @Given("browser is open")
    public void browserIsOpen() {
        driver = initDriver(driver);
        actions = new WebActions(driver);
        loginPage = new LoginPage(driver, actions);
        actions.maximizeWindow(driver);
        actions.waitForPageLoad(20);
    }

    @And("user is on login page")
    public void userIsOnLoginPage() {
        actions.openURL("https://demo.guru99.com/V4/");
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() throws InterruptedException {
        loginPage.clickLogin();
    }

    @Given("user is on manager home page")
    public void userIsOnManagerHomePage() {
        loginPage.checkManagerPage(driver);
    }

    @When("user clicks on new customer")
    public void userClicksOnNewCustomer() {
        loginPage.clickNewCustomer();
    }

    @And("verify all required fields and error messages")
    public void verifyAllRequiredFieldsAndErrorMessages() {
        loginPage.clickAllFields();
        loginPage.verifyErrorMessages();
    }

    @Then("user adds customer details")
    public void userAddsCustomerDetails() {
        System.out.println("User is navigated to add customer page");
        loginPage.enterCustomerDetails(customerName, dateOfBirth, address, city, state, pin, mobileNumber, email, password);
        loginPage.clickSubmitButton();
    }

    @And("verify added customer details")
    public void verifyAddedCustomerDetails() {
        loginPage.verifyAddedCustomerDetails(customerName, address, city, state, pin, mobileNumber, email);
        customerId = loginPage.getCustomerId();
    }

    @When("user clicks on edit customer")
    public void userClicksOnEditCustomer() {
        loginPage.clickEditCustomer();
    }

    @Then("user is on edit customer page")
    public void userIsOnEditCustomerPage() {
        loginPage.checkEditCustomerPage(driver);
    }

    @And("user enters customer id")
    public void userEntersCustomerId() {
        loginPage.enterCustomerId(customerId);
    }

    @Then("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        loginPage.clickSubmitButton();
    }

    @And("user edits the customer details")
    public void userEditsTheCustomerDetails() {
        loginPage.editCustomerDetails(updatedAddress, updatedCity, updatedState, updatedPIN, updatedMobileNumber, updatedEmail);
    }

    @When("user clicks on delete customer")
    public void userClicksOnDeleteCustomer() {
        loginPage.clickDeleteCustomer();
    }

    @Then("user is on delete customer page")
    public void userIsOnDeleteCustomerPage() {
        loginPage.checkDeleteCustomerPage(driver);
    }

    @And("user enters customer id for deletion")
    public void userEntersCustomerIdForDeletion() {
        loginPage.enterCustomerId(customerId);
    }

    @Then("user clicks on submit button for deletion")
    public void userClicksOnSubmitButtonForDeletion() {
        loginPage.clickSubmitButtonForDelete();
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Then("verify login page")
    public void verifyLoginPage() {
        loginPage.verifyLoginPage(driver);
    }

    @And("close the browser")
    public void closeTheBrowser() {
        tearDown(driver);
    }

}
