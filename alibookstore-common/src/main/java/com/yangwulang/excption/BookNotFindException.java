package com.yangwulang.excption;

/**
 * @author yangwulang
 */
public class BookNotFindException extends Exception{
    public BookNotFindException(){

    }

    public BookNotFindException(String message) {
        super(message);
    }

}
