package com.company.coffeeshop.screen.item;

import com.company.coffeeshop.entity.ItemTag;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.component.Label;
import io.jmix.ui.component.TagField;
import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;

@UiController("cs_Item.browse")
@UiDescriptor("item-browse.xml")
@LookupComponent("itemsTable")
public class ItemBrowse extends StandardLookup<Item> {
    @Autowired
    private UiComponents uiComponents;

    @Install(to = "itemsTable.tags", subject = "columnGenerator")
    private Component itemsTableTagsColumnGenerator(Item item) {
        Label<String> tagField = uiComponents.create(Label.class);
//        tagField.setHtmlEnabled(true);
//        tagField.setHtmlSanitizerEnabled(true);
//        tagField.setValue(UNSAFE_HTML);
        List<ItemTag> tagList = item.getTags();
        tagField.setValue(tagList.stream()
                .map(n -> n.getName())
                .collect(Collectors.joining(",")));
        return tagField;
    }

}