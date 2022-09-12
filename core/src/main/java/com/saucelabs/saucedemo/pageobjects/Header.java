package com.saucelabs.saucedemo.pageobjects;

import io.github.kgress.scaffold.webelements.ButtonWebElement;
import io.github.kgress.scaffold.webelements.DivWebElement;
import io.github.kgress.scaffold.webelements.LinkWebElement;
import lombok.Getter;

@Getter
public class Header {

  private final ButtonWebElement burgerMenu = new ButtonWebElement("#react-burger-menu-btn");
  private final LinkWebElement allItemsSidebar = new LinkWebElement("#inventory_sidebar_link");
  private final LinkWebElement aboutSidebar = new LinkWebElement("#about_sidebar_link");
  private final LinkWebElement logoutSidebar = new LinkWebElement("#logout_sidebar_link");
  private final LinkWebElement resetAppStateSidebar = new LinkWebElement("#reset_sidebar_link");
  private final DivWebElement companyLogo = new DivWebElement(".app_logo");
  private final LinkWebElement shoppingCart = new LinkWebElement(".shopping_cart_link");

  public CartPage clickShoppingCart() {
    getShoppingCart().click();
    return new CartPage();
  }

  public InventoryPage clickAllItemsFromSidebar() {
    getBurgerMenu().click();
    getAllItemsSidebar().click();
    return new InventoryPage();
  }

  public LoginPage clickLogoutFromSidebar() {
    getBurgerMenu().click();
    getLogoutSidebar().click();
    return new LoginPage();
  }

  /**
   * Returning as an {@link Object} strictly for demo purposes, since this navigates directly to
   * the saucelabs website.
   *
    * @return as {@link Object}
   */
  public Object clickAboutFromSidebar() {
    getBurgerMenu().click();
    getAboutSidebar().click();
    return new Object();
  }
}
