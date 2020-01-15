package com.yangwulang.alibookstorewebuser.controller;

import com.yangwulang.excption.UserNotFindException;
import com.yangwulang.pojo.Result;
import com.yangwulang.pojo.User;
import com.yangwulang.userservice.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangwulang
 */
@RestController
@Api("用户接口")
public class UserController {
    @Autowired
    UserService service;


    /**
     * 前端传入id查询用户信息
     *
     * @param id 用户ID
     * @return 查询成功返回状态码200，错误码0，错误信息null，数据null，
     * 查询失败返回状态码500，错误码500，错误信息未找到 ID为：" + id + "的用户信息!，数据null
     */
    @RequestMapping(value = "/user/{id}", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "id查询用户信息",notes = "查询成功返回状态码200，错误码0，错误信息null，数据null， 查询失败返回状态码500，错误码500，错误信息未找到 ID为：\" + id + \"的用户信息!，数据null")
    public Result<User> getUserById(@ApiParam("用户id") @PathVariable("id") long id) {
        User userById;
        try {
            userById = service.getUserById(id);
            return new Result<>(200, 0, null, userById);
        } catch (UserNotFindException e) {
            return new Result<>(500, 500, e.getMessage(), null);
        }
    }
}
