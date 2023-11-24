package com.company.coffeeshop.screen.order;

import com.company.coffeeshop.entity.Customer;
import com.company.coffeeshop.entity.OrderItemLink;
import com.google.common.base.Strings;
import io.jmix.ui.Actions;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.ValuePicker;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

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

    @Autowired
    protected CollectionContainer<OrderItemLink> itemsDc;

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

    @Subscribe(id = "itemsDc", target = Target.DATA_CONTAINER)
    protected void onItemsDcCollectionChange(CollectionContainer.CollectionChangeEvent<OrderItemLink> event) {
        calculateAmount();
    }

    @Subscribe(id = "itemsDc", target = Target.DATA_CONTAINER)
    protected void onItemsDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<OrderItemLink> event) {
        calculateAmount();
    }

    protected void calculateAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        for (OrderItemLink invoice : itemsDc.getItems()) {
            amount = amount.add(multiply(invoice.getQuantity(), invoice.getItem().getItemPrice()));
        }
        getEditedEntity().setTotalPrice(amount);
    }
    public static BigDecimal multiply ( int a, BigDecimal b ) {
        return BigDecimal.valueOf( a ).multiply( b );
    }
}