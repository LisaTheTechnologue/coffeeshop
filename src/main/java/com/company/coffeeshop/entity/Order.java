package com.company.coffeeshop.entity;

import com.company.coffeeshop.enums.DeliveryEnum;
import com.company.coffeeshop.interfaces.IFormatData;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JmixEntity
@Table(name = "CS_ORDER", schema = "shop_owner")
@Entity(name = "cs_Order")
@Setter
@Getter
@ToString
public class Order implements IFormatData {
    @InstanceName
    @Column(name = "order_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @NotNull
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "order_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTs;

    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "quantity")
    private Integer quantity;

    @NumberFormat(pattern = "#,###.##", decimalSeparator = ".", groupingSeparator = ",")
    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "add_id")
    private Long addId;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public DeliveryEnum getDelivery() {
        return delivery == null ? DeliveryEnum.DELIVERY : DeliveryEnum.fromId(delivery);
    }

    public void setDelivery(DeliveryEnum delivery) {
        this.delivery = delivery == null ? null : delivery.getId();
    }

    @Override
    public void formatData() {
        if (delivery == null) {
            delivery = getDelivery().getId();
        }
    }
}