package com.saucelabs.saucedemo.components;

import io.github.kgress.scaffold.BaseComponent;
import io.github.kgress.scaffold.webelements.ButtonWebElement;
import io.github.kgress.scaffold.webelements.DivWebElement;
import io.github.kgress.scaffold.webelements.LinkWebElement;
import lombok.Getter;

@Getter
public class CartItemComponent extends BaseComponent {

  private final DivWebElement quantity = new DivWebElement(".cart_quantity");
  private final LinkWebElement productLink = new LinkWebElement(".cart_item_label a");
  private final DivWebElement itemDescription = new DivWebElement(".inventory_item_desc");
  private final DivWebElement itemPrice = new DivWebElement(".inventory_item_price");
  private final ButtonWebElement removeFromCartButton = new ButtonWebElement(".item_pricebar button");
}
