package com.yangwulang.pojo;

import lombok.Data;

/**
 * @author yangwulang
 */
@Data
public class Result<T> {
    private int status;
    private int errorCode;
    private String errorMessage;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int status, int errorCode, String errorMessage, T data) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }
}
