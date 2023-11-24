package com.company.coffeeshop.screen.item;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Item;

@UiController("cs_Item.browse")
@UiDescriptor("item-browse.xml")
@LookupComponent("itemsTable")
public class ItemBrowse extends StandardLookup<Item> {
}