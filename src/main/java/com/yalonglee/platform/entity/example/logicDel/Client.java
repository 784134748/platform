package com.yalonglee.platform.entity.example.logicDel;

import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/2/9]
 * @see [相关类/方法]
 */
@Entity
public class Client extends BaseUUID {

    private String name;

    @Where(clause = "account_type = 'DEBIT'")
    @OneToMany(mappedBy = "client")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @OrderColumn(name = "order_id")
    private List<Account> debitAccounts = new ArrayList<>();

    @Where(clause = "account_type = 'CREDIT'")
    @OneToMany(mappedBy = "client")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @OrderColumn(name = "order_id")
    private List<Account> creditAccounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getDebitAccounts() {
        return debitAccounts;
    }

    public void setDebitAccounts(List<Account> debitAccounts) {
        this.debitAccounts = debitAccounts;
    }

    public List<Account> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(List<Account> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }
}
