package com.company.coffeeshop.mapper;

import com.company.coffeeshop.entity.user.User;
import com.company.coffeeshop.entity.user.UserDTO;
import io.jmix.security.role.ResourceRoleProvider;
import io.jmix.security.role.ResourceRoleRepository;
import io.jmix.security.role.assignment.RoleAssignmentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private RoleAssignmentProvider roleAssignmentProvider;
    @Autowired
    private ResourceRoleProvider resourceRoleProvider;
    @Autowired
    private ResourceRoleRepository resourceRoleRepository;

    public UserDTO toDto(User user) {

        // From jmix forum
        // The authorities collection is filled only for currently logged in user.
        // If you want to get a collection of role assignment for some specific user
        // then try the following service method: io.jmix.security.role.assignment.RoleAssignmentRepository#getAssignmentsByUsername
        String name = user.getFirstName() + " " + user.getLastName();
        List<String> roles = roleAssignmentProvider.getAssignmentsByUsername(user.getUsername())
                .stream()
                .map(x ->resourceRoleRepository.getRoleByCode(x.getRoleCode()).getName())
                .collect(Collectors.toList());

        return new UserDTO(name, roles);
    }

}
