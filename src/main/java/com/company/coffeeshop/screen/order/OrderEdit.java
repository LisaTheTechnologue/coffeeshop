package com.company.coffeeshop.screen.order;

import com.company.coffeeshop.entity.Customer;
import com.google.common.base.Strings;
import io.jmix.ui.Actions;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.ValuePicker;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("cs_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {
    @Autowired
    private Actions actions;
    @Autowired
    private EntityPicker<Customer> custField;
    private Customer customer;
    @Autowired
    private DataContext dataContext;

    @Subscribe("custField")
    public void onCustFieldFieldValueChange(ValuePicker.FieldValueChangeEvent<Customer>
                                                       event) {
        String value = event.getText();
        if (!Strings.isNullOrEmpty(value)) {
            customer = dataContext.create(Customer.class);
            customer.setUsername(value);
            custField.setValue(customer);
        }
    }
    
}