package com.company.coffeeshop.entity;

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

@JmixEntity
@Table(name = "CS_CUSTOMER", schema = "shop_owner")
@Entity(name = "cs_Customer")
@Setter
@Getter
@ToString
public class Customer {
    @InstanceName
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", nullable = false)
    @Id
    private Long custId;

    @Column(name = "cust_firstname", nullable = false)
    private String custFirstName;

    @Column(name = "cust_lastname", nullable = false)
    private String custLastName;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "emp_phonenum")
    private String empPhoneNum;

    @DeletedBy
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
}