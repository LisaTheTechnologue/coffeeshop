package com.company.coffeeshop.enums;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum ItemSizeEnum implements EnumClass<String> {

    S("S"),
    M("M"),
    L("L");

    private String id;

    ItemSizeEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ItemSizeEnum fromId(String id) {
        for (ItemSizeEnum at : ItemSizeEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}