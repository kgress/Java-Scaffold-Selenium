package com.saucelabs.saucedemo.page;

import com.retailmenot.scaffold.webelements.ButtonWebElement;
import com.retailmenot.scaffold.webelements.DivWebElement;
import com.retailmenot.scaffold.webelements.InputWebElement;
import com.saucelabs.saucedemo.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    @Getter @Setter private InputWebElement usernameInput = new InputWebElement(By.id("user-name"));
    @Getter @Setter private InputWebElement passwordInput = new InputWebElement(By.id("password"));
    @Getter @Setter private ButtonWebElement submitButton = new ButtonWebElement(By.className("btn_action"));
    @Getter @Setter private DivWebElement credentialsInfo =new DivWebElement(By.id("login_credentials"));

    public LoginPage() {}

    @Override
    public boolean isOnPage() {
        return credentialsInfo.isDisplayed();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
