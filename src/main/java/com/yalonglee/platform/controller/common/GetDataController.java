package com.yalonglee.platform.controller.common;

import com.yalonglee.common.base.GlobalParam;
import com.yalonglee.platform.entity.data.DictionaryData;
import com.yalonglee.platform.entity.data.Node;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(value = "数据结构")
public class GetDataController {

    /**
     * 枚举类型转json
     *
     * @param className
     * @return
     */
    @ApiOperation(value = "枚举类型")
    @RequestMapping(value = "enumerate.do", method = RequestMethod.GET)
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
    @ApiOperation(value = "数据字典")
    @RequestMapping(value = "dictionary.do", method = RequestMethod.GET)
    public List<DictionaryData> getDictionary(String dictionaryAlise) {
        return null;
    }

    /**
     * 返回树形JSON数据
     *
     * @param root
     * @return
     */
    @ApiOperation(value = "树形结构")
    @RequestMapping(value = "tree.do", method = RequestMethod.GET)
    public Node getTree(Long root) {
        return null;
    }

}
