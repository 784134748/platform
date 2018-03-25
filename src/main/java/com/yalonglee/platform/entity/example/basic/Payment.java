package com.yalonglee.platform.entity.example.basic;

import com.yalonglee.common.base.strategy.BaseUUID;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/9]
 * @see [相关类/方法]
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment extends BaseUUID {

    private BigDecimal amount;

    private boolean completed;

    @ManyToOne
    private Person person;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}