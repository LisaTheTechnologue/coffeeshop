package com.company.coffeeshop.repo;

import com.company.coffeeshop.entity.user.Employee;
import com.company.coffeeshop.entity.user.User;
import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends JmixDataRepository<Employee, UUID> {
    @Query("from Employee")
    public List<Employee> getEmployees();
}
