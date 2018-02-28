package com.yalonglee.platform.entity.example.logicDel;

import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

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
@Entity
@SecondaryTable(
        name = "account_details"
)
@SQLDelete(
        sql = "UPDATE account_details SET deleted = true WHERE id = ? "
)
@FilterDef(
        name = "activeAccount",
        parameters = @ParamDef(
                name = "active",
                type = "boolean"
        )
)
@Filter(
        name = "activeAccount",
        condition = "{a}.active = :active and {ad}.deleted = false",
        aliases = {
                @SqlFragmentAlias(alias = "a", table = "account"),
                @SqlFragmentAlias(alias = "ad", table = "account_details"),
        }
)
public class Account extends BaseUUID {

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Client client;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType type;

    private Double amount;

    private Double rate;

    private boolean active;

    @Column(table = "account_details")
    private boolean deleted;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
