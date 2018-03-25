package com.yalonglee.platform.controller.common;

import com.yalonglee.common.base.GlobalParam;
import com.yalonglee.platform.entity.data.DictionaryData;
import com.yalonglee.platform.entity.data.Node;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/7]
 * @see [相关类/方法]
 */
@RestController
@RequestMapping(value = "/get")
public class GetDataController {

    /**
     * 枚举类型转json
     *
     * @param className
     * @return
     */
    @RequestMapping(value = "enumerate.do")
    public Enum[] getEnumerate(String className) {
        if (null == className || className.isEmpty()) {
            return null;
        }
        try {
            Class<Enum> clazz = (Class<Enum>) Class.forName(GlobalParam.ENUM_PATH + className);
            Enum[] enums = clazz.getEnumConstants();
            return enums;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * 根据字典项别称返回字典项JSON数据
     *
     * @param dictionaryAlise
     * @return
     */
    @RequestMapping(value = "dictionary.do")
    public List<DictionaryData> getDictionary(String dictionaryAlise) {
        return null;
    }

    /**
     * 返回树形JSON数据
     *
     * @param root
     * @return
     */
    @RequestMapping(value = "tree.do")
    public Node getTree(Long root) {
        return null;
    }

}
