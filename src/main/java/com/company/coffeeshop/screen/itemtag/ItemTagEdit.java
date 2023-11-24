package com.company.coffeeshop.screen.itemtag;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.ItemTag;

@UiController("cs_ItemTag.edit")
@UiDescriptor("item-tag-edit.xml")
@EditedEntityContainer("itemTagDc")
public class ItemTagEdit extends StandardEditor<ItemTag> {
}