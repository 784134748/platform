package com.iflytek.operation.controller.common;

import com.iflytek.operation.common.base.GlobalParam;
import com.iflytek.operation.entity.data.Node;
import com.iflytek.operation.service.tree.TreeNodeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/7]
 * @see [相关类/方法]
 */
@Controller
@RequestMapping(value = "/get")
public class GetDataController {

    @Autowired
    private TreeNodeServiceI treeNodeServiceI;

    /**
     * 枚举类型转json
     *
     * @param className
     * @return
     */
    @RequestMapping(value = "enumerate.do")
    @ResponseBody
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
     * 数据字典转json
     *
     * @param business
     * @return
     */
    @RequestMapping(value = "dictionary.do")
    @ResponseBody
    public Map<String, Object> getDictionary(String business) {
        Map<String, Object> dictionary = new HashMap<>(16);
        dictionary.put("张三", 1);
        dictionary.put("李四", 2);
        dictionary.put("王五", 3);
        return dictionary;
    }

    /**
     * tree转json
     *
     * @return
     */
    @RequestMapping(value = "tree.do")
    @ResponseBody
    public Node getTree(Long root) {
        return null;
    }

}
