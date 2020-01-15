package com.yangwulang.alibookstorewebadmin.controller;

import com.yangwulang.pojo.User;
import com.yangwulang.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangwulang
 */
@RestController
public class AdminController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/s",produces = { "application/json;charset=UTF-8" })
    public User gets() {
        return null;
    }
}
