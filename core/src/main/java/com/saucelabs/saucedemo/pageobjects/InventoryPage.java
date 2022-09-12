package com.saucelabs.saucedemo.pageobjects;

import com.saucelabs.saucedemo.components.InventoryItemComponent;
import io.github.kgress.scaffold.BasePage;
import io.github.kgress.scaffold.webelements.DivWebElement;
import io.github.kgress.scaffold.webelements.DropDownWebElement;
import io.github.kgress.scaffold.webelements.LinkWebElement;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class InventoryPage extends BasePage {

  private final static String INVENTORY_ITEM_SELECTOR = ".inventory_item";
  private final Header header = new Header();
  private final DivWebElement inventoryList = new DivWebElement(By.cssSelector(".inventory_list"));
  private final DropDownWebElement sortDropDown = new DropDownWebElement(".product_sort_container");
  private final LinkWebElement cartButton = new LinkWebElement(".shopping_cart_link");

  public InventoryPage() {
    verifyIsOnPage(getInventoryList());
  }

  public List<InventoryItemComponent> getInventoryResultsList() {
    final var listOfElements = getInventoryList().findElements(DivWebElement.class, By.cssSelector(INVENTORY_ITEM_SELECTOR), true);
    return buildComponentList(listOfElements, InventoryItemComponent.class);
  }

  public List<String> getInventoryResultsByName() {
    final var listOfElements = getInventoryList()
        .findElements(DivWebElement.class, INVENTORY_ITEM_SELECTOR);
    return buildComponentList(listOfElements, InventoryItemComponent.class)
          .stream()
          .map(result -> result.getItemName().getText())
          .collect(Collectors.toList());
  }

  public void addItemsToCartByItemName(List<String> itemNames) {
    var inventory = getInventoryResultsList();
    inventory.stream()
        .filter(result -> itemNames.contains(result.getItemName().getText()))
        .forEach(InventoryItemComponent::clickAddToCartButton);
  }
}
