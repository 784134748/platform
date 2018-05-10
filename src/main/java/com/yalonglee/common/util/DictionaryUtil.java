package com.yalonglee.common.util;

import com.yalonglee.common.annotation.Dict;
import com.yalonglee.common.base.Dictionary;
import com.yalonglee.platform.entity.data.DictionaryData;
import com.yalonglee.platform.entity.example.basic.SexType;
import com.yalonglee.platform.entity.permission.AcountState;
import com.yalonglee.platform.vo.permission.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>《数据字典翻译工具类》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/10]
 * @see [相关类/方法]
 */
@Component
public class DictionaryUtil {

    //    @Autowired
//    private DictionaryService dictionaryService;
    private static DictionaryUtil dictionaryUnit;

//    public void setDictionaryService(DictionaryService dictionaryService){
//        this.dictionaryService = dictionaryService;
//    }

    @PostConstruct
    public void init() {
        dictionaryUnit = this;
//        dictionaryUnit.dictionaryService = this.dictionaryService;
    }

    /**
     * 添加的注解
     */
    private static List<Dict> annotations;

    /**
     * 添加注解的field
     */
    private static Field[] fields;

    /**
     * 添加注解的fieldName
     */
    private static StringBuilder fieldNames;

    /**
     * 数据字典列表
     */
    private static List<Dictionary> dictionaryList;

    /**
     * 已经获取的数据字典项
     */
    private static Map<String, String> dictionaryListRecord;


    /**
     * 翻译List
     *
     * @param collection
     * @return
     */
    public static Collection<?> getCollectionConvert(Collection<?> collection) {
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == 0) {
                getAnnotationsAndFieldsAndFieldNames(it.next().getClass());
                i++;
            }
            if (StringUtils.isNotEmpty(fieldNames)) {
                String[] fNames = fieldNames.toString().split(",");
                try {
                    translate(fNames, it.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return collection;
    }

    /**
     * 翻译Object
     *
     * @param o
     * @return
     */
    public static Object getObjectConvert(Object o) {
        getAnnotationsAndFieldsAndFieldNames(o.getClass());
        if (StringUtils.isNotEmpty(fieldNames)) {
            String[] fNames = fieldNames.toString().split(",");
            try {
                translate(fNames, o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return o;
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
            if (field.isAnnotationPresent(Dict.class)) {
                fieldNames.append(clazz.getSimpleName());
                fieldNames.append(".");
                fieldNames.append(field.getName());
                fieldNames.append(",");
                Dict annotation = field.getAnnotation(Dict.class);
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
        for (Dict annotation : annotations) {
            if (null != dictionaryListRecord.get(annotation.value())) {
                continue;
            }
            //根据code获取字典列表
//            List<Dictionary> list_custom = dictionaryUnit.dictionaryService.getList(annotation.value());
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
                    if (field.isAnnotationPresent(Dict.class)) {
                        for (Dictionary dictionary : dictionaryList) {
                            if (dictionary.getDictionaryAlise().equals(field.getAnnotation(Dict.class).value()) && dictionary.getOptionType().equals(val)) {
                                field.set(object, dictionary.getDataType());
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

    public static void main(String[] args) {

        /**
         * 数据字典项
         */
        Dictionary dictionary1 = new Dictionary();
        dictionary1.setDictionaryName("sex");
        dictionary1.setDictionaryAlise("性别");
        dictionary1.setOptionType("男");
        dictionary1.setDataType("0");
        Dictionary dictionary2 = new Dictionary();
        dictionary2.setDictionaryName("sex");
        dictionary2.setDictionaryAlise("性别");
        dictionary2.setOptionType("女");
        dictionary2.setDataType("1");

        /**
         * 测试数据
         */
        Set<String> roles = new TreeSet<>();
        roles.add("admin");
        roles.add("business");

        UserVo userVo1 = new UserVo();
        userVo1.setId("1");
        userVo1.setUsername("test");
        userVo1.setLocked(AcountState.NORMOL);
        userVo1.setSex(SexType.MAN);
        userVo1.setRoles(roles);

        UserVo userVo2 = new UserVo();
        userVo2.setId("2");
        userVo2.setUsername("test1");
        userVo2.setLocked(AcountState.LOCKED);
        userVo2.setSex(SexType.MAN);
        userVo2.setRoles(roles);

        List<UserVo> list = new ArrayList<>();
        list.add(userVo1);
        list.add(userVo2);


    }
}


