package pages;

import WebAction.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver webDriver;
    public WebActions actions;

    //Login Page WebElements
    @FindBy(name = "uid")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    // Manager Home Page WebElements
    @FindBy(linkText = "New Customer")
    WebElement newCustomerButton;

    @FindBy(name = "name")
    WebElement customerNameField;

    @FindBy(id = "dob")
    WebElement dobField;

    @FindBy(name = "addr")
    WebElement addressField;

    @FindBy(name = "city")
    WebElement cityField;

    @FindBy(name = "state")
    WebElement stateField;

    @FindBy(name = "pinno")
    WebElement pinField;

    @FindBy(name = "telephoneno")
    WebElement mobileNumberField;

    @FindBy(name = "emailid")
    WebElement emailField;

    @FindBy(id = "message")
    WebElement customerNameError;

    @FindBy(id = "message24")
    WebElement dateOfBirthError;

    @FindBy(id = "message3")
    WebElement addressError;

    @FindBy(id = "message4")
    WebElement cityError;

    @FindBy(id = "message5")
    WebElement stateError;

    @FindBy(id = "message6")
    WebElement pinError;

    @FindBy(id = "message7")
    WebElement mobileError;

    @FindBy(id = "message9")
    WebElement emailError;

    @FindBy(id = "message18")
    WebElement passwordError;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//td[contains(text(), 'Customer ID')]/following-sibling::td")
    WebElement customerIdValue;

    @FindBy(xpath = "//td[contains(text(), 'Customer Name')]/following-sibling::td")
    WebElement customerNameValue;

    @FindBy(xpath = "//td[contains(text(), 'Address')]/following-sibling::td")
    WebElement addressValue;

    @FindBy(xpath = "//td[contains(text(), 'City')]/following-sibling::td")
    WebElement cityValue;

    @FindBy(xpath = "//td[contains(text(), 'State')]/following-sibling::td")
    WebElement stateValue;

    @FindBy(xpath = "//td[contains(text(), 'Pin')]/following-sibling::td")
    WebElement pinValue;

    @FindBy(xpath = "//td[contains(text(), 'Mobile No.')]/following-sibling::td")
    WebElement mobileNoValue;

    @FindBy(xpath = "//td[contains(text(), 'Email')]/following-sibling::td")
    WebElement emailValue;

    //Edit Customer Page WebElements
    @FindBy(linkText = "Edit Customer")
    WebElement editCustomerButton;

    @FindBy(name = "cusid")
    WebElement customerIdField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitFormButton;

    //Delete Customer Page WebElements
    @FindBy(linkText = "Delete Customer")
    WebElement deleteCustomerButton;

    @FindBy(linkText = "Log out")
    WebElement logoutButton;

    //Login Page Methods
    public LoginPage(WebDriver driver, WebActions actions1) {
        webDriver = driver;
        actions = actions1;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        actions.sendText(userNameField, username);
    }

    public void enterPassword(String password) {
        actions.sendText(passwordField, password);
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(5000);
        actions.clickOnWebElement(loginButton);
    }

    //Manager Home Page Methods
    public void checkManagerPage(WebDriver driver) {
        String ManagerPageURL = actions.getCurrentURL(driver);
        String ManagerPageURLExpected = "https://demo.guru99.com/V4/manager/Managerhomepage.php";
        if (ManagerPageURL.equals(ManagerPageURLExpected))
            System.out.println("On Manager Home Page");
    }

    public void clickNewCustomer() {
        actions.clickOnWebElement(newCustomerButton);
    }

    public void clickCustomerName() {
        actions.clickOnWebElement(customerNameField);
    }

    public void enterCustomerName(String customerName) {
        actions.sendText(customerNameField, customerName);
    }

    public void clickDateOfBirth() {
        actions.clickOnWebElement(dobField);
    }

    public void enterDOB(String dob) {
        actions.sendText(dobField, dob);
    }

    public void clickAddress() {
        actions.clickOnWebElement(addressField);
    }

    public void enterAddress(String address) {
        actions.sendText(addressField, address);
    }

    public void clickCity() {
        actions.clickOnWebElement(cityField);
    }

    public void enterCity(String city) {
        actions.sendText(cityField, city);
    }

    public void clickState() {
        actions.clickOnWebElement(stateField);
    }

    public void enterState(String state) {
        actions.sendText(stateField, state);
    }

    public void clickPIN() {
        actions.clickOnWebElement(pinField);
    }

    public void enterPIN(String pin) {
        actions.sendText(pinField, pin);
    }

    public void clickMobileNumber() {
        actions.clickOnWebElement(mobileNumberField);
    }

    public void enterMobileNumber(String mobileNo) {
        actions.sendText(mobileNumberField, mobileNo);
    }

    public void clickEmail() {
        actions.clickOnWebElement(emailField);
    }

    public void enterEmail(String email) {
        actions.sendText(emailField, email);
    }

    public void clickPassword() {
        actions.clickOnWebElement(passwordField);
    }

    public void verifyErrorMessages() {
        String customerNameErrorText = actions.extractText(customerNameError);
        String customerNameErrorExpected = "Customer name must not be blank";
        actions.verifyErrorMessage(customerNameErrorText, customerNameErrorExpected, "Customer Name Error message verified");

        String dobErrorText = actions.extractText(dateOfBirthError);
        String dobErrorExpected = "Date Field must not be blank";
        actions.verifyErrorMessage(dobErrorText, dobErrorExpected, "Date Field Error message verified");

        String addressErrorText = actions.extractText(addressError);
        String addressErrorExpected = "Address Field must not be blank";
        actions.verifyErrorMessage(addressErrorText, addressErrorExpected, "Address Field Error message verified");

        String cityErrorText = actions.extractText(cityError);
        String cityErrorExpected = "City Field must not be blank";
        actions.verifyErrorMessage(cityErrorText, cityErrorExpected, "City Field Error message verified");

        String stateErrorText = actions.extractText(stateError);
        String stateErrorExpected = "State must not be blank";
        actions.verifyErrorMessage(stateErrorText, stateErrorExpected, "State Field Error message verified");

        String pinErrorText = actions.extractText(pinError);
        String pinErrorExpected = "PIN Code must not be blank";
        actions.verifyErrorMessage(pinErrorText, pinErrorExpected, "PIN Field Error message verified");

        String mobileNumberErrorText = actions.extractText(mobileError);
        String mobileNumberErrorExpected = "Mobile no must not be blank";
        actions.verifyErrorMessage(mobileNumberErrorText, mobileNumberErrorExpected, "Mobile Number Field Error message verified");

        String emailErrorText = actions.extractText(emailError);
        String emailErrorExpected = "Email-ID must not be blank";
        actions.verifyErrorMessage(emailErrorText, emailErrorExpected, "Email Field Error message verified");

        String passwordErrorText = actions.extractText(passwordError);
        String passwordErrorExpected = "Password must not be blank";
        actions.verifyErrorMessage(passwordErrorText, passwordErrorExpected, "Password Field Error message verified");
    }

    public void clickAllFields() {
        clickCustomerName();
        clickDateOfBirth();
        clickAddress();
        clickCity();
        clickState();
        clickPIN();
        clickMobileNumber();
        clickEmail();
        clickPassword();
        clickCustomerName();
    }

    public void enterCustomerDetails(String customerName, String dateOfBirth, String address, String city, String state, String pin, String mobileNumber, String email, String password) {
        enterCustomerName(customerName);
        enterDOB(dateOfBirth);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterPIN(pin);
        enterMobileNumber(mobileNumber);
        enterEmail(email);
        enterPassword(password);
    }

    public void clickSubmitButton() {
        actions.clickOnWebElement(submitButton);
    }

    public void verifyAddedCustomerDetails(String customerName, String address, String city, String state, String pin, String mobileNo, String email) {
        actions.verifyDetails(actions.extractText(customerNameValue), customerName, "Customer Name is Verified");
        actions.verifyDetails(actions.extractText(addressValue), address, "Address is Verified");
        actions.verifyDetails(actions.extractText(cityValue), city, "City is Verified");
        actions.verifyDetails(actions.extractText(stateValue), state, "State is Verified");
        actions.verifyDetails(actions.extractText(pinValue), pin, "PIN is Verified");
        actions.verifyDetails(actions.extractText(mobileNoValue), mobileNo, "Mobile Number is Verified");
        actions.verifyDetails(actions.extractText(emailValue), email, "Emailid is Verified");
    }

    public String getCustomerId() {
        return actions.extractText(customerIdValue);
    }

    //Edit Customer Page Methods
    public void clickEditCustomer() {
        actions.clickOnWebElement(editCustomerButton);
    }

    public void checkEditCustomerPage(WebDriver driver) {
        String EditCustomerPageURL = actions.getCurrentURL(driver);
        String EditCustomerPageURLExpected = "https://demo.guru99.com/V4/manager/EditCustomer.php";
        if (EditCustomerPageURL.equals(EditCustomerPageURLExpected))
            System.out.println("On Edit Customer Page");
    }

    public void enterCustomerId(String customerId) {
        actions.sendText(customerIdField, customerId);
    }

    public void editCustomerDetails(String updatedAddress, String updatedCity, String updatedState, String updatedPIN, String updatedMobileNumber, String updatedEmail) {
        actions.sendText(addressField, updatedAddress);
        actions.sendText(cityField, updatedCity);
        actions.sendText(stateField, updatedState);
        actions.sendText(pinField, updatedPIN);
        actions.sendText(mobileNumberField, updatedMobileNumber);
        actions.sendText(emailField, updatedEmail);
        actions.clickOnWebElement(submitFormButton);
        actions.alertAccept();
    }

    //Delete Customer Page Methods
    public void clickDeleteCustomer() {
        actions.clickOnWebElement(deleteCustomerButton);
    }

    public void checkDeleteCustomerPage(WebDriver driver) {
        String DeleteCustomerPageURL = actions.getCurrentURL(driver);
        String DeleteCustomerPageURLExpected = "https://demo.guru99.com/V4/manager/DeleteCustomerInput.php";
        if (DeleteCustomerPageURL.equals(DeleteCustomerPageURLExpected))
            System.out.println("On Delete Customer Page");
    }

    public void clickSubmitButtonForDelete() {
        actions.clickOnWebElement(submitButton);
        actions.alertAccept();
        actions.alertAccept();
    }

    public void clickLogoutButton() {
        actions.clickOnWebElement(logoutButton);
        actions.alertAccept();
    }

    public void verifyLoginPage(WebDriver driver) {
        String LoginPageURL = actions.getCurrentURL(driver);
        String LoginPageURLExpected = "https://demo.guru99.com/V4/index.php";
        if (LoginPageURL.equals(LoginPageURLExpected))
            System.out.println("On Login Page");
    }

}
