package com.yalonglee.platform.entity.example.envers;

import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/2/7]
 * @see [相关类/方法]
 */
@Audited
@Entity(name = "Customer")
public class Customer extends BaseUUID {

    private String firstName;

    private String lastName;

    @Temporal( TemporalType.TIMESTAMP )
    @Column(name = "created_on")
    @CreationTimestamp
    private Date createdOn;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
