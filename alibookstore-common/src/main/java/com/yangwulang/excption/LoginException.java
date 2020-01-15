package com.yangwulang.excption;

/**
 * 登录异常
 * @author yangwulang
 */
public class LoginException extends Exception{
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

}
