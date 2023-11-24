package com.company.coffeeshop.entity.user;

import com.company.coffeeshop.enums.EmpShiftEnum;
import com.company.coffeeshop.interfaces.IFormatData;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@JmixEntity
@Table(name = "CS_EMPLOYEE", schema = "shop_owner")
@Entity(name = "cs_Employee")
@Getter
@Setter
@DiscriminatorValue("Employee")
public class Employee extends User implements IFormatData {
//    @InstanceName
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "emp_ID", nullable = false)
//    @Id
//    private Long empId;

    //    @Column(name = "emp_firstname", nullable = false)
//    private String empFirstName;
//
//    @Column(name = "emp_lastname", nullable = false)
//    private String empLastName;
    @Column(name = "emp_pos", nullable = false)
    private String empPos;

    @Column(name = "emp_shift")
    private String empShift;

    @Column(name = "emp_phonenum")
    private String empPhoneNum;

    @NumberFormat(pattern = "#,###.##", decimalSeparator = ".", groupingSeparator = ",")
    @Column(name = "monthly_wage", nullable = false)
    private Float monthlyWage;

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

    public EmpShiftEnum getEmpShift() {
        return empShift == null ? EmpShiftEnum.MORNING : EmpShiftEnum.fromId(empShift);
    }

    public void setEmpShift(EmpShiftEnum empShift) {
        this.empShift = empShift == null ? null : empShift.getId();
    }

    @Override
    public void formatData() {
        if (empShift == null) {
            empShift = getEmpShift().getId();
        }
    }
}