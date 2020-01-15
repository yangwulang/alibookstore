package com.yangwulang.excption;

/**
 * @author yangwulang
 */
public class AdminNotFindException extends Exception {
    public AdminNotFindException() {
    }

    public AdminNotFindException(String message) {
        super(message);
    }
}
