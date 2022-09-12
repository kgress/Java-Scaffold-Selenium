package com.saucelabs.saucedemo.pageobjects;

import com.saucelabs.saucedemo.components.CartItemComponent;
import io.github.kgress.scaffold.BasePage;
import io.github.kgress.scaffold.webelements.ButtonWebElement;
import io.github.kgress.scaffold.webelements.DivWebElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

@Getter
public class CartPage extends BasePage {

  private final Header header = new Header();
  private final DivWebElement cartList = new DivWebElement(".cart_list");
  private final DivWebElement yourCartHeaderLabel = new DivWebElement(".title");
  private final ButtonWebElement continueShoppingButton = new ButtonWebElement("#continue-shopping");
  private final ButtonWebElement checkoutButton = new ButtonWebElement("#checkout");

  public CartPage() {
    verifyIsOnPage(getYourCartHeaderLabel());
  }

  public List<CartItemComponent> getCartItems() {
    final var cartItemSelector = ".cart_item";
    var elements = getCartList().findElements(
            DivWebElement.class, By.cssSelector(cartItemSelector), true);
    return buildComponentList(elements, CartItemComponent.class);
  }
}
