package com.saucelabs.saucedemo.page;

import com.retailmenot.scaffold.webelements.ButtonWebElement;
import com.retailmenot.scaffold.webelements.DivWebElement;
import com.saucelabs.saucedemo.BasePage;
import org.openqa.selenium.By;

public class InventoryPage extends BasePage {
    private DivWebElement inventoryContainer = new DivWebElement(By.className("inventory_container"));
    private DivWebElement inventoryList = new DivWebElement(By.className("inventory_list"));
    private DivWebElement inventoryHeader = new DivWebElement(By.className("header_secondary_container"));

    /**
     * Returns the Div containing the item specified (zero-indexed)
     * @param itemNumber
     * @return
     */
    private DivWebElement getItemNumber(int itemNumber) {
        inventoryList.getWait().waitUntilDisplayed();
        return inventoryList.findElement(DivWebElement.class, By.cssSelector(String.format("div.inventory_item:nth-of-type(%d)", itemNumber)));
    }

    public String getItemName(int itemNumber) {
        DivWebElement itemName = getItemNumber(itemNumber).findElement(DivWebElement.class, By.className("inventory_item_name"));
        return itemName.getText();
    }

    public String getItemDescription(int itemNumber) {
        DivWebElement itemDesc = getItemNumber(itemNumber).findElement(DivWebElement.class, By.className("inventory_item_desc"));
        return itemDesc.getText();
    }

    public String getItemPrice(int itemNumber) {
        DivWebElement itemPrice = getItemNumber(itemNumber).findElement(DivWebElement.class, By.className("inventory_item_price"));
        return itemPrice.getText();
    }

    public void addItemToCart(int itemNumber) {
        ButtonWebElement addToCart = getItemNumber(itemNumber).findElement(ButtonWebElement.class, By.className("btn_primary"));
        addToCart.click();
    }

    @Override
    protected boolean isOnPage() {
        return inventoryHeader.isDisplayed();
    }

    public boolean itemAddedToCart(int itemNumber) {
        return getItemNumber(itemNumber).findElement(ButtonWebElement.class, By.className("btn_secondary")).isDisplayed();
    }
}
