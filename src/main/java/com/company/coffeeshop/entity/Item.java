package com.company.coffeeshop.entity;

import com.company.coffeeshop.enums.DeliveryEnum;
import com.company.coffeeshop.enums.ItemSizeEnum;
import com.company.coffeeshop.enums.PaymentMethodEnum;
import com.company.coffeeshop.interfaces.IFormatData;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.CurrencyValue;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JmixEntity
@Table(name = "CS_ITEM", schema = "shop_owner",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"item"})})
@Entity(name = "cs_Item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements IFormatData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    @Id
    private Long itemId;

    @InstanceName
    @Column(name = "item")
    private String item;

    @Column(name = "item_cat")
    private String itemCat;

    @Column(name = "item_size")
    private String itemSize;

    @NumberFormat(pattern = "##.##", decimalSeparator = ".", groupingSeparator = ",")
    @Column(name = "item_price")
    @CurrencyValue(currency = "$")
    private BigDecimal itemPrice;

    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @JoinTable(name = "cs_item_TAG_LINK", schema = "shop_owner",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "item_TAG_ID"))
    @ManyToMany
    private List<ItemTag> tags;

    public ItemSizeEnum getItemSize() {
        return itemSize == null ? ItemSizeEnum.M : ItemSizeEnum.fromId(itemSize);
    }

    public void setItemSize(ItemSizeEnum itemSize) {
        this.itemSize = itemSize == null ? null : itemSize.getId();
    }


    @Override
    public void formatData() {
        if(itemSize == null) {
            itemSize = getItemSize().getId();
        }
    }
}