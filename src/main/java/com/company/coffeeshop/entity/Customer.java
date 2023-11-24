package com.company.coffeeshop.entity;

import com.company.coffeeshop.entity.user.User;
import com.company.coffeeshop.enums.PaymentMethodEnum;
import com.company.coffeeshop.interfaces.IFormatData;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "CS_CUSTOMER", schema = "shop_owner")
@Entity(name = "cs_Customer")
@Setter
@Getter
@ToString
@DiscriminatorValue("Customer")
//@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Customer extends User implements IFormatData {
//    @InstanceName
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cust_id", nullable = false)
//    @Id
//    private Long custId;
//
//    @Column(name = "cust_name", nullable = false)
//    private String custName;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "cust_phonenum")
    private String custPhoneNum;

    @Column(name = "cust_address")
    private String custAddress;

//    @DeletedBy
//    @Column(name = "DELETED_BY")
//    private String deletedBy;
//
//    @DeletedDate
//    @Column(name = "DELETED_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedDate;
//
//    @CreatedBy
//    @Column(name = "CREATED_BY")
//    private String createdBy;
//
//    @CreatedDate
//    @Column(name = "CREATED_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @LastModifiedBy
//    @Column(name = "UPDATED_BY")
//    private String updatedBy;
//
//    @LastModifiedDate
//    @Column(name = "UPDATED_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedDate;

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod == null ? PaymentMethodEnum.CASH : PaymentMethodEnum.fromId(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.getId();
    }

    @Override
    public void formatData() {
        if(paymentMethod == null) {
            paymentMethod = getPaymentMethod().getId();
        }
    }
}