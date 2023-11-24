package com.company.coffeeshop.entity.user;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@JmixEntity(name = "cs_UserDTO")
@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private List<String> roles;


}