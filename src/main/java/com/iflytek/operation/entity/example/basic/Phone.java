package com.iflytek.operation.entity.example.basic;

import com.iflytek.operation.common.base.strategy.BaseUUID;

import javax.persistence.*;
import java.util.*;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/9]
 * @see [相关类/方法]
 */
@Entity
public class Phone extends BaseUUID {

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    @Column(name = "phone_number")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneType type;

    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_id")
    private List<Call> calls = new ArrayList<>();

    @OneToMany(mappedBy = "phone")
    @MapKey(name = "timestamp")
    @MapKeyTemporal(TemporalType.TIMESTAMP)
    private Map<Date, Call> callHistory = new HashMap<>();

    @ElementCollection
    private List<Date> repairTimestamps = new ArrayList<>();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public Map<Date, Call> getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(Map<Date, Call> callHistory) {
        this.callHistory = callHistory;
    }

    public List<Date> getRepairTimestamps() {
        return repairTimestamps;
    }

    public void setRepairTimestamps(List<Date> repairTimestamps) {
        this.repairTimestamps = repairTimestamps;
    }
}
