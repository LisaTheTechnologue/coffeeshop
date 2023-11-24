package com.company.coffeeshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "CS_ITEM_TAG", schema = "shop_owner")
@Entity(name = "cs_ItemTag")
@Data
public class ItemTag {
    @JmixGeneratedValue
    @Column(name = "item_tag_id", nullable = false)
    @Id
    private Long id;

    @Column(name = "item_tag_name")
    @InstanceName
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;
}