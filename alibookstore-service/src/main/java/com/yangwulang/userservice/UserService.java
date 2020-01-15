package com.yangwulang.userservice;

import com.yangwulang.dao.NoticeDao;
import com.yangwulang.dao.UserDao;
import com.yangwulang.excption.*;
import com.yangwulang.pojo.Notice;
import com.yangwulang.pojo.User;
import com.yangwulang.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author yangwulang
 */
@Component
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao dao;
    @Autowired
    private NoticeDao ds;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户信息
     * @throws UserNotFindException 未找到用户抛出异常
     */
    public  User getUserById(long id) throws UserNotFindException {
        LOGGER.info("==>" + UserService.class + "#getUserById");
        User userById = null;
        try {
            userById = ParseToBeanImpl.parseToBean(User.class, (String) redisUtils.get(""+id));
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        if (userById == null) {
            userById = dao.getUserById(id);
            if (userById == null) {
                throw new UserNotFindException("未找到 ID为：" + id + "的用户信息!");
            } else {
                redisUtils.set(userById.getId() + "", userById.toString());
            }
        }
        return userById;
    }

    /**
     * 登录方法，用户名或密码错误会
     *
     * @param name 用户输入的用户名
     * @param pass 用户输入的密码
     * @return 用户对象
     * @throws LoginException 登录产生的异常
     */
    public User login(String name, String pass) throws LoginException {
        System.out.println(dao);
        User user = dao.selectUserByUsernameAndPassword(name, pass);
        if (user == null) {
            throw new LoginException("登录失败,用户名或密码错误！");
        }
        if (user.getIsActive() == FinalUtils.IS_ACTIVE_FAILURE) {
            throw new LoginException("用户未激活");
        }
        return user;
    }

    public void register(User user) throws RegisterException {
        user.setId(IDKeyUtil.generateId());
        String activeCode = String.valueOf(IDKeyUtil.generateId());
        user.setActiveCode(activeCode);
        int i = dao.insertUser(user);
        if (i == FinalUtils.IS_REGISTER_FAILURE) {
            throw new RegisterException("注册失败");
        }
        try {
            MailUtils.activeTemplate(user.getEmail(), activeCode);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void activeUser(long id) throws ActiveException {
        int i = dao.updateUserToActive(id);
        if (i == FinalUtils.IS_ACTIVE_FAILURE) {
            throw new ActiveException("未知异常，激活未成功！请联系管理员");
        }
    }

    public Notice getNowNotice() throws NoticeNotFindException {
        Notice notice = ds.selectNoticeNew();
        if (notice == null) {
            throw new NoticeNotFindException("公告暂无数据");
        }
        return notice;
    }

    public String forgetPass(String email, String name) throws UserNotFindException {
        String pass = dao.forgetPass(email, name);
        if (pass == null) {
            throw new UserNotFindException("用户邮箱错误");
        }
        return pass;
    }

}
