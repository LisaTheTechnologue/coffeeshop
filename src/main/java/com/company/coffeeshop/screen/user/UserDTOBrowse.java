package com.company.coffeeshop.screen.user;

import com.company.coffeeshop.interfaces.UserService;
import com.company.coffeeshop.mapper.UserMapper;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.coffeeshop.entity.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@UiController("cs_UserDTO.browse")
@UiDescriptor("user-dto-browse.xml")
@LookupComponent("userDToesTable")
public class UserDTOBrowse extends StandardLookup<UserDTO> {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Install(to = "userDToesDl", target = Target.DATA_LOADER)
    private List<UserDTO> userDToesDlLoadDelegate(LoadContext<UserDTO> loadContext) {
        // Here you can load entities from an external store
        return userService.getAllUsers()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }


}