package com.saucelabs.saucedemo;

import com.retailmenot.scaffold.webdriver.WebDriverNavigation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.saucelabs.saucedemo.page.LoginPage;

@Component
public class SauceDemoNavigation extends WebDriverNavigation {
    private final String baseEnvironmentUrl;

    public SauceDemoNavigation(@Value("${base-environment-url}") String baseEnvironmentUrl) {
        this.baseEnvironmentUrl = baseEnvironmentUrl;
    }

    public LoginPage navigateToLoginPage() {
        // Start the web test from a base environment URL pulled in from a Spring env variable
        getWebDriverWrapper().get(baseEnvironmentUrl);
        return new LoginPage();
    }
}
