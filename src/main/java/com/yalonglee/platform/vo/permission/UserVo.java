package com.yalonglee.platform.vo.permission;

import com.yalonglee.common.annotation.Dict;
import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.example.basic.SexType;
import com.yalonglee.platform.entity.permission.AcountState;

import java.util.Set;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/20]
 * @see [相关类/方法]
 */
public class UserVo extends BaseUUID {

    /**
     * 邮箱 | 登录帐号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 联系方式
     */
    private String address;
    /**
     * 学生证件
     */
    private String number;
    /**
     * 性别
     */
    private SexType sex;
    /**
     * salt
     */
    private String salt;
    /**
     * 账号锁定
     */
    private AcountState locked;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public AcountState getLocked() {
        return locked;
    }

    public void setLocked(AcountState locked) {
        this.locked = locked;
    }

}
