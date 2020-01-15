package com.yangwulang.excption;

/**
 * @author yangwulang
 */
public class RedisException extends Exception{
    public RedisException() {
    }

    public RedisException(String message) {
        super(message);
    }
}
