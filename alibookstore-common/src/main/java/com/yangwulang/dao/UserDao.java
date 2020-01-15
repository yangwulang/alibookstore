package com.yangwulang.dao;

import com.yangwulang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangwulang
 */
@Mapper
public interface UserDao {
    /**
     * 根据id查询用户信息
     *
     * @param id 唯一id
     * @return 用户对象
     */
    User getUserById(@Param("id") long id);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 影响的行数
     */
    int insertUser(@Param("user") User user);

    /**
     * 获取所有的用户
     *
     * @return 所有用户对象
     */
    List<User> selectAllUser();

    /**
     * 根据用户名和密码查询用户
     *
     * @param name 用户名
     * @param pass 密码
     * @return 用户信息
     */
    User selectUserByUsernameAndPassword(@Param("name") String name, @Param("password") String pass);

    /**
     * 根据id用户激活
     *
     * @param activeCode 用户id
     * @return 返回激活状态
     */
    int updateUserToActive(@Param("activeCode") long activeCode);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User selectUserByUsername(@Param("username") String username);

    /**
     * 根据邮箱和用户名槎找用户密码
     *
     * @param email 邮箱
     * @param name  用户名
     * @return 用户密码
     */
    String forgetPass(@Param("email") String email, @Param("name") String name);

}
