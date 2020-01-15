package com.yangwulang.dao;

import com.yangwulang.pojo.Admin;
import com.yangwulang.pojo.Book;
import com.yangwulang.pojo.Notice;
import com.yangwulang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangwulang
 */
@Mapper
public interface AdminDao {
    /**
     * 根据id获取管理员信息
     *
     * @param id 管理员id
     * @return 管理员
     */
    Admin getAdminById(long id);

    /**
     * 根据用户名密码获取管理员信息
     *
     * @param name 用户名
     * @param pass 密码
     * @return 管理员信息
     */
    Admin getAdminByNameAndPassWord(@Param("name") String name, @Param("pass") String pass);

    /**
     * 根据邮箱获取密码
     *
     * @param email 邮箱
     * @return 密码
     */
    String getAdminPassword(@Param("email") String email);

    /**
     * 获取所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> selectAllUser();

    /**
     * 添加用户信息
     *
     * @param user 用户
     * @return 影响行数
     */
    int saveUser(@Param("user") User user);

    /**
     * 修改
     *
     * @param user 用户
     * @return 影响行数
     */
    int updateUser(@Param("user") User user);

    /**
     * 根据用户id删除用户
     *
     * @param user 用户
     * @return 影响行数
     */
    int deleteUserById(@Param("user") User user);

    /**
     * 获取所有的公告
     *
     * @return 所有公告信息
     */
    List<Notice> selectAllNotice();

    /**
     * 修改公告信息
     *
     * @param notice 公告对象
     * @return 影响行数
     */
    int updateNotice(@Param("notice") Notice notice);

    /**
     * 修改书籍信息
     *
     * @param book 书籍对象
     * @return 影响行数
     */
    int updateBook(@Param("book") Book book);

    /**
     * 获得用户的总条数
     *
     * @return 用户的总条数
     */
    int getAllUserCount();

    /**
     * 获得公告的总条数
     *
     * @return 公告的总条数
     */
    int getAllNoticeCount();

    /**
     * 模糊搜索用户
     *
     * @param files 用户字段信息
     * @return 用户信息
     */
    List<User> fuzzySearchUser(@Param("files") String files);

    /**
     * 插入公告
     *
     * @param notice 公告对象
     * @return 影响条数
     */
    int insertNotice(@Param("notice") Notice notice);

    /**
     * 模糊搜索公告
     *
     * @param files 公告字段信息
     * @return 公告信息
     */
    List<Notice> fuzzySearchNotice(@Param("files") String files);

    /**
     * 根据id删除公告
     *
     * @param id 公告id
     * @return 影响条数
     */
    int deleteNoticeById(@Param("id") long id);
}
