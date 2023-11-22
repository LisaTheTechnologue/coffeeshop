package com.company.coffeeshop.enums;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum DeliveryEnum implements EnumClass<String> {

    DINEIN("Dine-in"),
    TAKEOUT("Takeout"),
    DELIVERY("Delivery");

    private String id;

    DeliveryEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static DeliveryEnum fromId(String id) {
        for (DeliveryEnum at : DeliveryEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}