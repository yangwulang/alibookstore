package com.yangwulang.pojo;

import lombok.Data;


/**
 * @author yangwulang
 */
@Data
public class User {
    private long id;
    private String name;
    private String password;
    private String telPhone;
    private String address;
    private int isLowAdmin;
    private String email;
    private String activeCode;
    private int isActive;

    public User() {
    }

    public User(long id, String name, String password,
                String telPhone, String address, int isLowAdmin, String email, String activeCode, int isActive) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telPhone = telPhone;
        this.address = address;
        this.isLowAdmin = isLowAdmin;
        this.email = email;
        this.activeCode = activeCode;
        this.isActive = isActive;
    }

    public User(String name, String password, String telPhone,
                String address, int isLowAdmin, String email, String activeCode, int isActive) {
        this.name = name;
        this.password = password;
        this.telPhone = telPhone;
        this.address = address;
        this.isLowAdmin = isLowAdmin;
        this.email = email;
        this.activeCode = activeCode;
        this.isActive = isActive;
    }

}
