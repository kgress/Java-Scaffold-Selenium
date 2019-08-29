package com.saucelabs.saucedemo.login;

import com.saucelabs.saucedemo.BaseTest;
import com.saucelabs.saucedemo.page.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        navigation.navigateToLoginPage().login("standard_user", "secret_sauce");
        Assert.assertFalse(new LoginPage().isOnPage());
    }
}
