package com.company.coffeeshop.screen.order;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Order;

@UiController("cs_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
public class OrderBrowse extends StandardLookup<Order> {
}