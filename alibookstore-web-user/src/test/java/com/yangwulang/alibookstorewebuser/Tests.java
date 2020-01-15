package com.yangwulang.alibookstorewebuser;

import com.yangwulang.pojo.User;
import com.yangwulang.utils.ParseToBeanImpl;

import java.lang.reflect.InvocationTargetException;

public class Tests {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
       User user = ParseToBeanImpl.parseToBean(User.class,"User(id=366604910712111104,name=sdfsd, password=asdfas, telPhone=11, address=湖南省长沙市暮云区, isLowAdmin=20, email=, activeCode=12, isActive=10)");
        System.out.println(user);
    }
}
