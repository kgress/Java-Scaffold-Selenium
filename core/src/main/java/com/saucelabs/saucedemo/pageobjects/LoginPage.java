package com.saucelabs.saucedemo.pageobjects;

import io.github.kgress.scaffold.BasePage;
import io.github.kgress.scaffold.webelements.ButtonWebElement;
import io.github.kgress.scaffold.webelements.DivWebElement;
import io.github.kgress.scaffold.webelements.InputWebElement;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LoginPage extends BasePage {

    private final InputWebElement usernameInput = new InputWebElement(By.id("user-name"));
    private final InputWebElement passwordInput = new InputWebElement(By.id("password"));
    private final ButtonWebElement submitButton = new ButtonWebElement(By.className("btn_action"));
    private final DivWebElement credentialsInfo = new DivWebElement(By.id("login_credentials"));
    private final DivWebElement loginErrorMessage = new DivWebElement(By.cssSelector("[data-test=error]"));

    public LoginPage() {
        verifyIsOnPage(getUsernameInput(), getPasswordInput());
    }

    /**
     * Performs a login action with a provided username and password
     *
     * @param username the username as {@link String}
     * @param password the password as {@link String}
     */
    public InventoryPage login(String username, String password) {
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getSubmitButton().click();
        return new InventoryPage();
    }
}
