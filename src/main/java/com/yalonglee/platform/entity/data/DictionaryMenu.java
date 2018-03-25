package com.yalonglee.platform.entity.data;

import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/19]
 * @see [相关类/方法]
 */
@Entity
public class DictionaryMenu extends BaseUUID {

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
    @OneToMany(mappedBy="dictionaryMenu", orphanRemoval = true)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<DictionaryData> dictionaryDatas = new ArrayList<>();

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

    public List<DictionaryData> getDictionaryDatas() {
        return dictionaryDatas;
    }

    public void setDictionaryDatas(List<DictionaryData> dictionaryDatas) {
        this.dictionaryDatas = dictionaryDatas;
    }
}
