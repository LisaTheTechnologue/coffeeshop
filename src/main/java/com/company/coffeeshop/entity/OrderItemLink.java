package com.company.coffeeshop.entity;

import com.company.coffeeshop.enums.ItemSizeEnum;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@JmixEntity
@Table(name = "CS_ORDER_ITEM_LINK", schema = "shop_owner")
@Entity(name = "cs_OrderItemLink")
@Data
public class OrderItemLink {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    protected Item item;

    @Column(name = "QUANTITY")
    protected Integer quantity;

    @Column(name = "item_size")
    private String itemSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    @InstanceName
    public String getInstanceName() {
        return item.getItem() + " " + quantity;
    }

    public ItemSizeEnum getItemSize() {
        return itemSize == null ? ItemSizeEnum.M : ItemSizeEnum.fromId(itemSize);
    }

    public void setItemSize(ItemSizeEnum itemSize) {
        this.itemSize = itemSize == null ? null : itemSize.getId();
    }
}