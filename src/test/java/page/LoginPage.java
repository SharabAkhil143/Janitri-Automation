package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By userIdInput = By.id("userId");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("loginButton");
    private By passwordToggle = By.cssSelector(".eye-icon"); // Adjust selector as needed

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIdInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public void togglePasswordVisibility() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordToggle)).click();
    }

    public boolean isPasswordMasked() {
        WebElement passwordField = driver.findElement(passwordInput);
        return passwordField.getAttribute("type").equals("password");
    }

    public String getErrorMessage() {
        By errorMsg = By.cssSelector(".error-message"); // Adjust selector as needed
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}
