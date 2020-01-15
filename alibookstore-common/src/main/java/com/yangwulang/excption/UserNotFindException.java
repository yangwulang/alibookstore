package com.yangwulang.excption;

/**
 * @author yangwulang
 */
public class UserNotFindException extends Exception{
    public UserNotFindException(){
        super();
    }

    public UserNotFindException(String message) {
        super(message);
    }
}
