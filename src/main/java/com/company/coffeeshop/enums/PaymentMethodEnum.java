package com.company.coffeeshop.enums;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum PaymentMethodEnum implements EnumClass<String> {

    CASH("Cash"),
    CARD("Card");

    private String id;

    PaymentMethodEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PaymentMethodEnum fromId(String id) {
        for (PaymentMethodEnum at : PaymentMethodEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}