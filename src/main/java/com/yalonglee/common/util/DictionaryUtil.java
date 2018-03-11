package com.yalonglee.common.util;

import com.yalonglee.common.annotation.Dictionary;
import com.yalonglee.platform.entity.data.DictionaryData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>《数据字典翻译工具类》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/10]
 * @see [相关类/方法]
 */
@Component
public class DictionaryUtil {

    @Autowired
//    private DictionaryService dictionaryService;
    private static DictionaryUtil dictionaryUnit;

//    public void setDictionaryService(DictionaryService dictionaryService){
//        this.dictionaryService = dictionaryService;
//    }

    @PostConstruct
    public void init(){
        dictionaryUnit = this;
//        dictionaryUnit.dictionaryService = this.dictionaryService;
    }
    /**
     * 添加注解的field
     */
    private static Field[] fields;

    /**
     * 添加注解的fieldName
     */
    private static StringBuilder fieldNames;

    /**
     * 添加的注解
     */
    private static List<Dictionary> annotations;

    /**
     * 数据字典列表
     */
    private static List<DictionaryData> dictionaryList;

    /**
     * 已经获取的数据字典项
     */
    private static Map<String, String> dictionaryListRecord;


    /**
     * 对外提供的转换接口
     * @param list
     * @return
     */
    public static List<?> Convert(List<?> list) {
        if (null != list & list.size() > 0) {
            getAnnotationsAndFieldsAndFieldNames(list.get(0).getClass());
            if (StringUtils.isNotEmpty(fieldNames)) {
                String[] fNames = fieldNames.toString().split(",");
                try {
                    for (Object object : list) {
                        translate(fNames, object);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 获取clazz中添加注解的annotations、fields和fieldNames
     *
     * @param clazz
     */
    private static void getAnnotationsAndFieldsAndFieldNames(Class clazz) {
        fieldNames = new StringBuilder();
        annotations = new ArrayList<>(16);
        fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (null != field.getType().getClassLoader()) {
                getAnnotationsAndFieldsAndFieldNames(field.getType());
                continue;
            }
            if (field.isAnnotationPresent(Dictionary.class)) {
                fieldNames.append(clazz.getSimpleName());
                fieldNames.append(".");
                fieldNames.append(field.getName());
                fieldNames.append(",");
                Dictionary annotation = field.getAnnotation(Dictionary.class);
                annotations.add(annotation);
            }
        }
        initDictionnaryData();
    }

    /**
     * 加载数据字典(需自定义配置)
     */
    private static void initDictionnaryData() {
        dictionaryList = new ArrayList<>();
        dictionaryListRecord = new HashMap<>(8);
        for (Dictionary annotation : annotations) {
            if (null != dictionaryListRecord.get(annotation.value())) {
                continue;
            }
            //根据code获取字典列表
//            List<DictionaryData> list_custom = dictionaryUnit.dictionaryService.getList(annotation.value());
//            if (list_custom != null && list_custom.size() > 0) {
//                dictionaryList.addAll(list_custom);
//                //记录已经获取的字典code
//                dictionaryListRecord.put(annotation.value(), annotation.value());
//            }
        }
    }

    /**
     * 数据字典翻译
     *
     * @param fNames
     * @param object
     */
    private static void translate(String[] fNames, Object object) throws Exception {
        String classFieldName = "";
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fNames.length; i++) {
            for (Field field : fields) {
                if (null != field.getType().getClassLoader()) {
                    if (i == 0) {
                        classFieldName += field.getName() + ",";
                    }
                    continue;
                }
                String[] n = fNames[i].split("\\.");
                if (clazz.getSimpleName().equals(n[0]) && field.getName().equals(n[1])) {
                    field.setAccessible(true);
                    String val = String.valueOf(field.get(object));
                    if (field.isAnnotationPresent(Dictionary.class)) {
                        for (DictionaryData dictionaryData : dictionaryList) {
                            if (dictionaryData.getOptionType().equals(val)) {
                                field.set(object, dictionaryData.getDataType());
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        String[] classFieldNames = classFieldName.split(",");
        for (String fieldName : classFieldNames) {
            if (StringUtils.isNotEmpty(fieldName)) {
                Field classField = clazz.getDeclaredField(fieldName);
                classField.setAccessible(true);
                if (null != classField.get(object)) {
                    translate(fNames, classField.get(object));
                }
            }
        }
    }
}
