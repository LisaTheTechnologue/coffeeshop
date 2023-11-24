package com.company.coffeeshop.screen.item;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Item;

@UiController("cs_Item.edit")
@UiDescriptor("item-edit.xml")
@EditedEntityContainer("itemDc")
public class ItemEdit extends StandardEditor<Item> {
}