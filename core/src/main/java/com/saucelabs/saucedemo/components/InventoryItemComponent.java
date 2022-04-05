package com.saucelabs.saucedemo.components;

import io.github.kgress.scaffold.BaseComponent;
import io.github.kgress.scaffold.webelements.ButtonWebElement;
import io.github.kgress.scaffold.webelements.DivWebElement;
import lombok.Getter;

@Getter
public class InventoryItemComponent extends BaseComponent {

    private final String someString = "testing";
    private final DivWebElement itemName = new DivWebElement(".inventory_item_name");
    private final DivWebElement itemDescription = new DivWebElement(".inventory_item_desc");
    private final DivWebElement itemPrice = new DivWebElement(".inventory_item_price");
    private final ButtonWebElement addToCart = new ButtonWebElement(".btn_primary");
    private final ButtonWebElement remove = new ButtonWebElement(".btn_secondary");

    public void clickAddToCartButton() {
        getAddToCart().click();
    }

    public void clickRemoveButton() {
        getRemove().click();
    }
}
