package com.saucelabs.saucedemo.inventory;

import com.saucelabs.saucedemo.BaseTest;
import com.saucelabs.saucedemo.page.InventoryPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InventoryTest extends BaseTest {
    @Test
    public void testItem3Label() {
        navigation.navigateToLoginPage().login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage();
        Assert.assertEquals("Item name was not correct: item 3, 'Sauce Labs Bolt T-Shirt'", "Sauce Labs Bolt T-Shirt", inventoryPage.getItemName(3));
    }

    @Test
    public void testItem3Price() {
        navigation.navigateToLoginPage().login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage();
        Assert.assertEquals("Item price was not correct: item 3, '$15.99", "$15.99", inventoryPage.getItemPrice(3));
    }

    @Test
    public void testItem3Description() {
        navigation.navigateToLoginPage().login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage();
        Assert.assertEquals("Item description was not correct: item 3, 'Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.'", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", inventoryPage.getItemDescription(3));
    }

    @Test
    public void testAddOneItem() {
        navigation.navigateToLoginPage().login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addItemToCart(3);
        Assert.assertTrue(inventoryPage.itemAddedToCart(3));
    }
}
