package Base;

import WebAction.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.Random;

public class BaseClass {
    public WebDriver driver;
    public WebActions actions;
    public LoginPage loginPage;
    public String customerName = "Vraj";
    public String dateOfBirth = "04/01/2004";
    public String address = "Address";
    public String city = "Vadodara";
    public String state = "Gujarat";
    public String pin = "123456";
    public String mobileNumber = "9876543210";
    public String password = "123456";
    public String customerId;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public static String generateRandomString() {
        StringBuilder stringBuilder = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(index));
        }
        return stringBuilder.toString();
    }

    public String email = generateRandomString() + "@gmail.com";

    public WebDriver initDriver(WebDriver driver) {
        driver = new ChromeDriver();
        return driver;
    }

    public void tearDown(WebDriver driver) {
        driver.quit();
    }

    public String updatedAddress = "Address1";
    public String updatedCity = "Vadodara1";
    public String updatedState = "Gujarat1";
    public String updatedPIN = "456789";
    public String updatedMobileNumber = "0123456789";
    public String updatedEmail = generateRandomString() + "@gmail.com";
}
