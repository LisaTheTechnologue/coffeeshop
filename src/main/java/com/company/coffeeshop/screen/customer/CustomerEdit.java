package com.company.coffeeshop.screen.customer;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Customer;

@UiController("cs_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {
}