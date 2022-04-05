package com.saucelabs.saucedemo.pages;

import com.saucelabs.saucedemo.components.InventoryItemComponent;
import io.github.kgress.scaffold.BasePage;
import io.github.kgress.scaffold.webelements.DivWebElement;
import io.github.kgress.scaffold.webelements.DropDownWebElement;
import io.github.kgress.scaffold.webelements.LinkWebElement;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
@Getter
public class InventoryPage extends BasePage {

  private final static String INVENTORY_ITEM_SELECTOR = ".inventory_item";
  private final DivWebElement inventoryList = new DivWebElement(By.cssSelector("#inventory_container"));
  private final DropDownWebElement sortDropDown = new DropDownWebElement(".product_sort_container");
  private final LinkWebElement cartButton = new LinkWebElement(".shopping_cart_link");

  public InventoryPage() {
    verifyIsOnPage(getInventoryList());
  }

  public final List<InventoryItemComponent> getInventoryResultsList() {
    final var listOfElements = getInventoryList().findElements(DivWebElement.class, INVENTORY_ITEM_SELECTOR);
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

  public CartPage clickCartButton() {
    getCartButton().click();
    return new CartPage();
  }
}
