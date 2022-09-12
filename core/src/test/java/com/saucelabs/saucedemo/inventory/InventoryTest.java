package com.saucelabs.saucedemo.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.saucelabs.saucedemo.BaseTest;
import com.saucelabs.saucedemo.components.InventoryItemComponent;
import org.junit.jupiter.api.Test;

/**
 * This class is an example test class pertaining to the login page <a href>https://www.saucedemo.com/inventory.html</a>.
 * The following tests are merely examples of tests you'd consider writing.
 *
 * Ensure that all of your test classes are importing the junit5 {@link Test} annotation from junit.jupiter.api and *not* junit4.
 */
public class InventoryTest extends BaseTest {

    /**
     * An example of a test checking the sauce labs bolt t shirt label is correct
     */
    @Test
    public void testItemOneName() {
        final var expectedString = "Sauce Labs Backpack";
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var listOfComponents = inventoryPage.getInventoryResultsList();
        final var itemName1 = listOfComponents.get(0).getItemName().getText();
        assertEquals(expectedString, itemName1);

        getWebDriverWrapper().navigate().refresh();
        assertEquals(expectedString, itemName1);
    }

    @Test
    public void testItemThreePrice() {
        final var expectedPrice = "$15.99";
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var listOfComponents = inventoryPage.getInventoryResultsList();
        assertEquals(expectedPrice, listOfComponents.get(2).getItemPrice().getText());
    }

    @Test
    public void testItemThreeDescription() {
        final var expectedDescription = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American " +
                "Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var thirdResult = inventoryPage.getInventoryResultsList().get(2);
        assertEquals(expectedDescription, thirdResult.getItemDescription().getText());
    }

    @Test
    public void testAddItemTwo() {
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var secondResult = inventoryPage.getInventoryResultsList().get(1);
        secondResult.clickAddToCartButton();
        assertTrue(secondResult.getRemove().isDisplayed());
    }

    @Test
    public void testRemoveItemFive() {
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var fifthResult = inventoryPage.getInventoryResultsList().get(4);
        fifthResult.clickAddToCartButton();
        fifthResult.clickRemoveButton();
        assertTrue(fifthResult.getAddToCart().isDisplayed());
    }

    @Test
    public void testAllResultsHaveAddToCartButton() {
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        inventoryPage.getInventoryResultsList().forEach(result -> assertTrue(result.getAddToCart().isDisplayed()));
    }

    @Test
    public void testFirstFourResultsContainSauce() {
        final var expectedItemName = "Sauce";
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        inventoryPage.getInventoryResultsList()
                .stream()
                .limit(4)
                .map(InventoryItemComponent::getItemName)
                .forEach(result -> assertTrue(result.getText().contains(expectedItemName)));
    }

    @Test
    public void testFindLastShirtAndPriceMatches() {
        final var expectedPrice = "$15.99";
        final var allTheThingsShirtPartial = "allTheThings()";
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var shirt = inventoryPage.getInventoryResultsList()
                .stream()
                .filter(item -> item.getItemName().getText().contains(allTheThingsShirtPartial))
                .map(InventoryItemComponent::getItemPrice)
                .findFirst()
                .orElse(null);

        assertNotNull(shirt);
        assertEquals(expectedPrice, shirt.getText());
    }

    @Test
    public void testFindFleeceJacketAndAddToCart() {
        final var fleeceJacketPartial = "Fleece";
        final var inventoryPage = navigation.navigateToInventoryPage(USERNAME, PASSWORD);
        final var fleeceJacket = inventoryPage.getInventoryResultsList()
                .stream()
                .filter(item -> item.getItemName().getText().contains(fleeceJacketPartial))
                .findFirst()
                .orElse(null);

        assertNotNull(fleeceJacket);
        fleeceJacket.clickAddToCartButton();
        assertTrue(fleeceJacket.getRemove().isDisplayed());
    }
}
