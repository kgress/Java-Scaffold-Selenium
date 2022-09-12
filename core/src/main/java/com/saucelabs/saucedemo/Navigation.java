package com.saucelabs.saucedemo;

import com.saucelabs.saucedemo.pageobjects.InventoryPage;
import com.saucelabs.saucedemo.pageobjects.LoginPage;
import io.github.kgress.scaffold.WebDriverNavigation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Navigation extends WebDriverNavigation {

    protected static final String STANDARD_USER_USERNAME = "standard_user";
    protected static final String STANDARD_USER_PASSWORD = "secret_sauce";
    private final String baseEnvironmentUrl;

    /**
     * A constructor that injects the {@link #baseEnvironmentUrl} from application.properties
     *
     * @param baseEnvironmentUrl the {@link #baseEnvironmentUrl} as {@link String}. These must always be strings when using spring
     *                           variables.
     */
    public Navigation(@Value("${base-environment-url}") String baseEnvironmentUrl) {
        this.baseEnvironmentUrl = baseEnvironmentUrl;
    }

    /**
     * A navigation method for navigating to the login page, <a href>https://www.saucedemo.com/</a>
     *
     * Performs a selenium get(String) using the {@link #baseEnvironmentUrl}. Afterwards, builds a new {@link LoginPage}
     * and returns it.
     *
     * @return as {@link LoginPage}
     */
    public LoginPage navigateToLoginPage() {
        // Start the web test from the base environment url above
        getWebDriverWrapper().get(baseEnvironmentUrl);

        // Return the new instance of the LoginPage
        return new LoginPage();
    }

    /**
     * A navigation method for navigating to the Inventory Page, <a href>https://www.saucedemo.com/inventory.html</a>
     *
     * Creates a new instance of the {@link LoginPage} by hitting the {@link #navigateToLoginPage()} method. Afterwards,
     * performs a login action with the {@link LoginPage} using a provided username and password. Then, builds a new {@link InventoryPage}
     * and returns it.
     *
     * @param username the username as {@link String}
     * @param password the password as {@link String}
     * @return as {@link InventoryPage}
     */
    public InventoryPage navigateToInventoryPage(String username, String password) {
        // Create a new instance of the login page by navigating to it with the navigateToLoginPage method
        var loginPage = navigateToLoginPage();

        // With the new instance, invoke the login method from the login page
        return loginPage.login(username, password);
    }

    /**
     * A navigation method that will navigate to the inventory page from
     * {@link #navigateToInventoryPage(String, String)} with the standard user credentials. Since
     * the sauce demo site is not a real production website, we can hard code these values. For
     * sensitive data, make sure to wrap it as a secret and load it in as an environment variable.
     *
     * @return as {@link InventoryPage}
     */
    public InventoryPage navigateToInventoryPageAsStandardUser() {
        return navigateToInventoryPage(STANDARD_USER_USERNAME, STANDARD_USER_PASSWORD);
    }
}
