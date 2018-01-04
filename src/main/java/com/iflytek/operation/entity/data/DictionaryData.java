package com.iflytek.operation.entity.data;

import javax.persistence.*;
import java.util.Objects;

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
public class DictionaryData {

    @Id
    @GeneratedValue
    private Long id;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dictionaryMenu_id", nullable=false)
    private DictionaryMenu dictionaryMenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DictionaryData that = (DictionaryData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(optionType, that.optionType) &&
                Objects.equals(dataType, that.dataType) &&
                Objects.equals(dictionaryMenu, that.dictionaryMenu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, optionType, dataType, dictionaryMenu);
    }
}
