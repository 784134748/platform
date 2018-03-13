package com.yalonglee.platform.entity.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * <p>《数据字典数据》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/1/4]
 * @see [相关类/方法]
 */
@Entity
public class DictionaryData extends BaseUUID {

    /**
     * 操作类型（前台展示）
     */
    private String optionType;
    /**
     * 存储类型（后台存储）
     */
    private String dataType;
    /**
     * dictionaryData --> dictionaryMenu
     */
    @JSONField(serialize = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="dictionaryMenu_id", nullable=false)
    private DictionaryMenu dictionaryMenu;

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public DictionaryMenu getDictionaryMenu() {
        return dictionaryMenu;
    }

    public void setDictionaryMenu(DictionaryMenu dictionaryMenu) {
        this.dictionaryMenu = dictionaryMenu;
    }
}
