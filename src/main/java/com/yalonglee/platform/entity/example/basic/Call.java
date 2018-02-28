package com.yalonglee.platform.entity.example.basic;

import com.yalonglee.common.base.strategy.BaseUUID;

import javax.persistence.*;
import java.util.Date;

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
@Table(name = "phone_call")
public class Call extends BaseUUID {

    @ManyToOne
    private Phone phone;

    @Column(name = "call_timestamp")
    private Date timestamp;

    private int duration;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
