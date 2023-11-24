package com.company.coffeeshop.screen.customer;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Customer;

@UiController("cs_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
public class CustomerBrowse extends StandardLookup<Customer> {
}