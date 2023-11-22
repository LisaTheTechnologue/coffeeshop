package com.company.coffeeshop.enums;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum EmpShiftEnum implements EnumClass<String> {

    MORNING("Morning"),
    EVENING("Evening");

    private String id;

    EmpShiftEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EmpShiftEnum fromId(String id) {
        for (EmpShiftEnum at : EmpShiftEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}