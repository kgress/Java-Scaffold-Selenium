package com.saucelabs.saucedemo.pages;

import com.saucelabs.saucedemo.components.CartItemComponent;
import io.github.kgress.scaffold.BasePage;
import io.github.kgress.scaffold.webelements.ButtonWebElement;
import io.github.kgress.scaffold.webelements.DivWebElement;
import java.util.List;
import lombok.Getter;

@Getter
public class CartPage extends BasePage {

  private final static String CART_ITEM_SELECTOR = ".cart_item";
  private final DivWebElement resultsContainer = new DivWebElement(".cart_list");
  private final DivWebElement yourCartHeader = new DivWebElement(".title");
  private final ButtonWebElement continueShoppingButton = new ButtonWebElement("#continue-shopping");
  private final ButtonWebElement checkoutButton = new ButtonWebElement("#checkout");

  public CartPage() {
    verifyIsOnPage(getYourCartHeader());
  }

  public List<CartItemComponent> getCartComponents() {
    var elements = resultsContainer.findElements(DivWebElement.class, CART_ITEM_SELECTOR);
    return buildComponentList(elements, CartItemComponent.class);
  }
}
