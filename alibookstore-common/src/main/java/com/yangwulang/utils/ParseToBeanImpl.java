package com.yangwulang.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 将一段特定的字符串序列化成一个对应的bean
 *
 * @author yangwulang
 */
public class ParseToBeanImpl {
    /**
     * 保存从字符串中解析出来的字段和值
     */
    private static final Map<String, String> FILEDMAP = new LinkedHashMap<>();

    /**
     * 将传入的字符串转化成对应的Class类型的javaBean
     *
     * @param clazz 将转变的类型Class
     * @param value 需要转换的字符串
     * @param <T>   处理的对象
     * @return 转换处理的对象
     * @throws IllegalAccessException    s
     * @throws InvocationTargetException s
     * @throws InstantiationException    实例不成功产生的异常
     */
    public static <T> T parseToBean(Class<?> clazz, String value)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (value == null) {
            return null;
        }
        Object o = clazz.newInstance();
        String substring = value.substring((clazz.getSimpleName() + "(").length(), value.length() - 1);
        for (String field : substring.split(FinalUtils.COMMA)) {
            String[] split = field.split(FinalUtils.EQUALSIGN);
            if (split.length != 2) {
                String[] newString = new String[2];
                newString[0] = split[0];
                newString[1] = "";
                split = newString;
            }
            FILEDMAP.put(split[0].trim(), split[1]);
        }
        BeanUtils.populate(o, FILEDMAP);
        return (T) o;
    }

}
