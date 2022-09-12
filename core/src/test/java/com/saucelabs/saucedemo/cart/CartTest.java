package com.saucelabs.saucedemo.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.saucelabs.saucedemo.BaseTest;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

  @Test
  public void testCartContainsExpectedItems() {
    final var sauceLabsBackpack = "Sauce Labs Backpack";
    final var sauceLabsFleeceJacket = "Sauce Labs Fleece Jacket";
    final var listOfItemNames = Arrays.asList(sauceLabsBackpack, sauceLabsFleeceJacket);
    var inventoryPage = navigation.navigateToInventoryPageAsStandardUser();
    inventoryPage.addItemsToCartByItemName(listOfItemNames);
    var cartPage = inventoryPage.getHeader().clickShoppingCart();
    var cartItems = cartPage.getCartItems();

    assertEquals(2, cartItems.size());
    var expectedIndex = new AtomicInteger();
    cartItems.forEach(item -> {
        var expectedItemName = listOfItemNames.get(expectedIndex.get());
        assertTrue(item.getProductLink().getText().contains(expectedItemName));
        expectedIndex.getAndIncrement();
    });
  }
}
