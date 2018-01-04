package com.iflytek.operation.entity.data;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/19]
 * @see [相关类/方法]
 */
@Entity
public class DictionaryMenu {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 字典项名称（业务名称）
     */
    private String dictionaryName;
    /**
     * 字典项别称（业务代码）
     */
    private String dictionaryAlise;
    /**
     * dictionaryMenu --> dictionaryData
     */
    @OneToMany(cascade=ALL, mappedBy="dictionaryMenu")
    private Set<DictionaryData> dictionaryDatas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getDictionaryAlise() {
        return dictionaryAlise;
    }

    public void setDictionaryAlise(String dictionaryAlise) {
        this.dictionaryAlise = dictionaryAlise;
    }

    public Set<DictionaryData> getDictionaryDatas() {
        return dictionaryDatas;
    }

    public void setDictionaryDatas(Set<DictionaryData> dictionaryDatas) {
        this.dictionaryDatas = dictionaryDatas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DictionaryMenu that = (DictionaryMenu) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dictionaryName, that.dictionaryName) &&
                Objects.equals(dictionaryAlise, that.dictionaryAlise) &&
                Objects.equals(dictionaryDatas, that.dictionaryDatas);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dictionaryName, dictionaryAlise, dictionaryDatas);
    }
}
