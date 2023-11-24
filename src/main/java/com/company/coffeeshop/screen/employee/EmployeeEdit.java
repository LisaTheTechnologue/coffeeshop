package com.company.coffeeshop.screen.employee;

import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.user.Employee;

@UiController("cs_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeEdit extends StandardEditor<Employee> {
}