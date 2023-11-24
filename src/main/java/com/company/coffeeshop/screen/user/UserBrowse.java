package com.company.coffeeshop.screen.user;

import com.company.coffeeshop.entity.Customer;
import com.company.coffeeshop.entity.user.Employee;
import com.company.coffeeshop.entity.user.User;
import io.jmix.core.Metadata;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import liquibase.pro.packaged.E;

import javax.inject.Inject;

@UiController("cs_User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<User> usersTable;

    @Inject
    private Metadata metadata;

    @Subscribe("createBtn.createEmployee")
    protected void onCreateBtnCreateCat(Action.ActionPerformedEvent event) {
        Employee employee = metadata.create(Employee.class);
        showCreateEditorForUser(employee);
    }

    @Subscribe("createBtn.createCustomer")
    protected void onCreateBtnCreateCustomer(Action.ActionPerformedEvent event) {
        Customer customer = metadata.create(Customer.class);
        showCreateEditorForUser(customer);
    }

    @Subscribe("createBtn.createUser")
    protected void onCreateBtnCreateUser(Action.ActionPerformedEvent event) {
        User user = metadata.create(User.class);
        showCreateEditorForUser(user);
    }

    private void showCreateEditorForUser(User user) {
        screenBuilders.editor(usersTable)
                .editEntity(user)
                .build()
                .show();
    }
}