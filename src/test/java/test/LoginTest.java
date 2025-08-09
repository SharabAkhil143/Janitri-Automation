package test;

import base.BaseTest;
import page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled());
    }
    @Test
    public void testPasswordMaskedButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("dummyPassword");
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked initially");
        loginPage.togglePasswordVisibility();
        Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be visible after toggle");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("invalidUser");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"), "Error message should appear for invalid login");
    }
}
