package com.company.coffeeshop.screen.orderitemlink;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.OrderItemLink;

@UiController("cs_OrderItemLink.edit")
@UiDescriptor("order-item-link-edit.xml")
@EditedEntityContainer("orderItemLinkDc")
public class OrderItemLinkEdit extends StandardEditor<OrderItemLink> {
}