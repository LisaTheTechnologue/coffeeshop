package com.company.coffeeshop.entity;

import com.company.coffeeshop.entity.user.Employee;
import com.company.coffeeshop.enums.DeliveryEnum;
import com.company.coffeeshop.interfaces.IFormatData;
import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@JmixEntity
@Table(name = "CS_ORDER", schema = "shop_owner")
@Entity(name = "cs_Order")
@Data
public class Order implements IFormatData {
    @InstanceName
    @Column(name = "order_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @NumberFormat(pattern = "#,###.##", decimalSeparator = ".", groupingSeparator = ",")
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "address")
    private String address;

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

//        @JoinTable(name = "cs_order_item_link",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id"))
//    @ManyToMany(mappedBy = "")
//    @OnDelete(DeletePolicy.UNLINK)
//    protected Set<Item> itemSet;
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected Set<OrderItemLink> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    @OnDelete(DeletePolicy.UNLINK)
    protected Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    @OnDelete(DeletePolicy.UNLINK)
    protected Employee employee;

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