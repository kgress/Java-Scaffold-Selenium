package com.saucelabs.saucedemo.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.saucelabs.saucedemo.BaseTest;
import com.saucelabs.saucedemo.components.InventoryItemComponent;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

  @Test
  public void testUpdatedScrollIntoView() {
    final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
    final var listOfComponents = inventoryPage.getInventoryResultsList();
    listOfComponents.forEach(InventoryItemComponent::clickAddToCartButton);
    final var cartPage = inventoryPage.clickCartButton();
    final var cartItems = cartPage.getCartComponents();
    assertEquals(6, cartItems.size());
    assertTrue(cartItems.get(5).getProductLink().getText().contains("allTheThings"));
  }
}
