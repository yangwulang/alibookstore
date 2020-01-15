package com.yangwulang.excption;

/**
 * @author yangwulang
 */
public class NoticeNotFindException extends Exception{
    public NoticeNotFindException() {
    }

    public NoticeNotFindException(String message) {
        super(message);
    }
}
