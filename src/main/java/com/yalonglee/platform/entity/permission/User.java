package com.yalonglee.platform.entity.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.example.basic.SexType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

/**
 * <p>《用户》
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
public class User extends BaseUUID {

    /**
     * 邮箱 | 登录帐号
     */
    @NotEmpty(message = "用户名不能为空")
    @NaturalId(mutable = true)
    @Column(unique = true)
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 宿舍楼栋
     */
    private String address;
    /**
     * 学生证件
     */
    private String number;
    /**
     * 性别
     */
    @Convert(converter = SexType.SexTypeConvert.class)
    @Column(name = "sex")
    private SexType sex;
    /**
     * salt
     */
    private String salt;
    /**
     * 账号锁定
     */
    @Convert(converter = AcountState.AcountStateConvert.class)
    private AcountState locked;

    /**
     * user --> role 多对多处理
     */
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "USER_ROLE",
            joinColumns =
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private List<Role> roles = new ArrayList<>();
    /**
     * user --> group 多对多处理
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Group> groups = new ArrayList<>();

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
