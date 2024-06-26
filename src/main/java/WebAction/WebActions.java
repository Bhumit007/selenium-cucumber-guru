package WebAction;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActions {
    public WebDriver driver = null;
    public static WebDriverWait wait;
    public static WebDriverWait waitForInstallation;
    public static JavascriptExecutor executor;

    public WebActions(WebDriver webDriver) {
        driver = webDriver;
        executor = (JavascriptExecutor) webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        waitForInstallation = new WebDriverWait(webDriver, Duration.ofSeconds(60));
    }

    public void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnWebElement(WebElement element) {
        waitForVisibilityOfElement(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    public void waitForElementToBeClickable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void minimizeWindow(WebDriver driver) {
        driver.manage().window().minimize();
    }

    public String extractText(WebElement element) {
        return element.getText();
    }

    public void waitForPageLoad(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void verifyErrorMessage(String actual, String expected, String message) {
        if (actual.equals(expected))
            System.out.println(message);
        else
            System.out.println(expected + " error message is not verified");
    }

    public void verifyDetails(String actual, String expected, String message) {
        if (actual.equals(expected))
            System.out.println(message);
        else
            System.out.println(expected + " is not verified");
    }

    public void alertAccept() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
