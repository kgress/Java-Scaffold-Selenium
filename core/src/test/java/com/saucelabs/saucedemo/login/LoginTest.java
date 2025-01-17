package com.saucelabs.saucedemo.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.saucelabs.saucedemo.BaseTest;
import org.junit.jupiter.api.Test;

/**
 * This class is an example test class pertaining to the login page <a href>https://www.saucedemo.com/</a>
 * The following tests are merely examples of tests you'd consider writing.
 *
 * Ensure that all of your test classes are importing the junit5 {@link Test} annotation from junit.jupiter.api and *not* junit4.
 */
public class LoginTest extends BaseTest {

    // Local static final variables that are not needed in other test files
    private static final String BAD_USERNAME = "bad_username";
    private static final String BAD_PASSWORD = "0";

    /**
     * An example of a login test with page verification by navigating to the login page, performing the login action, and
     * then asserting the user is on the inventory page by creating the new instance of the inventory page in the assertion itself.
     */
    @Test
    public void loginSuccessExampleTest() {
        // Navigate to the login page and log in with good user credentials using the data from the BaseTest file
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);

        // Assert that the user is now on the inventory page using the isOnPage() method
        assertTrue(inventoryPage.getInventoryList().isDisplayed());
    }

    /**
     * Example of a login failure test on username
     */
    @Test
    public void loginBadUsernameExampleTest() {
        // Create a new instance of the login page by using the navigateToLoginPage from the Navigation file
        final var loginPage = navigation.navigateToLoginPage();

        // Perform a bad login action by using the BAD_USERNAME final variable on this file and the PASSWORD final variable from the BaseTest File
        loginPage.login(BAD_USERNAME, PASSWORD);

        // Assert the login error message is displayed
        assertTrue(loginPage.getLoginErrorMessage().isDisplayed());
    }

    /**
     * Another example of a login failure test with a bad password
     */
    @Test
    public void loginBadPasswordExampleTest() {
        // Create a new instance of the login page by using the navigateToLoginPage from the Navigation file
        final var loginPage = navigation.navigateToLoginPage();

        // Perform a bad login action by using the USERNAME final variable on the BaseTest file and the BAD_PASSWORD final variable on this file
        loginPage.login(USERNAME, BAD_PASSWORD);

        // Assert the login error message is displayed
        assertTrue(loginPage.getLoginErrorMessage().isDisplayed());
    }
}
