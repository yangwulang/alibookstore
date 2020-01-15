package com.yangwulang.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 邮件工具类
 *
 * @author yangwulang
 */
public class MailUtils {
    private static Properties props = new Properties();
    private static StringBuilder messageText = new StringBuilder();

    /**
     * 存储了待发送邮件的信息，一个邮件标题对应一个邮件正文
     */
    private static Map<String, StringBuilder> body = new HashMap<>();

    static {
        props.setProperty(FinalUtils.MAIL_TRANSPORT_PROTOCOL, FinalUtils.MAIL_TRANSPORT_PROTOCOL_VALUE);
        props.setProperty(FinalUtils.MAIL_HOSTS, FinalUtils.MAIL_HOSTS_VALUE);
        props.setProperty(FinalUtils.MAIL_SMTP_AUTH, FinalUtils.MAIL_SMTP_AUTH_VALUE);
    }

    /**
     * 发送邮件
     *
     * @param email 发送地址
     * @throws MessagingException s
     */
    public static void sendEmail(String email, Map<String, StringBuilder> map) throws MessagingException {
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("yangchaochao514", "yangwulang514");
            }
        };
        Session session = Session.getInstance(props, auth);
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        // 设置发送者
        message.setFrom(new InternetAddress("yangchaochao514@163.com"));
        // 设置发送方式与接收者
        message.setRecipient(RecipientType.TO, new InternetAddress(email));
        //内容以html格式发送,防止被当成垃圾邮件
        map.forEach((title, body) -> {
            try {
                message.setSubject(title.toString());
                message.setContent(body.toString(), "text/html;charset=utf-8");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
        Transport.send(message);
    }

    /**
     * 注册邮件的模板
     *
     * @param email 邮箱地址
     * @param msg   发送的信息
     * @throws MessagingException s
     */
    public static void registerEmailTemplate(String email, String msg) throws MessagingException {
        messageText.append("<span>Hi，您好:</span></br>");
        messageText.append("<span>请激活: ").append(msg).append(" </span></br>");
        messageText.append("<span>出于安全原因，该验证码将于10分钟后失效。请勿将验证码透露给他人。</span></br>");
        body.put("用户激活", messageText);
        sendEmail(email, body);
    }

    /**
     * 忘记密码的模板方法
     * <br>
     * 默认为：
     * <br>
     * <span>Hi，您好:</span>
     * </br>
     * <span>你的密码为: 传入的信息 </span></br>
     *
     * @param email 邮箱地址
     * @param msg   发送的信息
     * @throws MessagingException s
     */
    public static void forgetPassWordTemplate(String email, String msg) throws MessagingException {
        messageText.append("<span>Hi，您好:</span></br>");
        messageText.append("<span>你的密码为: ").append(msg).append(" </span></br>");
        body.put("忘记密码", messageText);
        sendEmail(email, body);
    }

    /**
     * 激活的模板方法
     * <br>
     * 默认为:
     * 指向<a href='http://localhost:8080/bookstoreweball_war/register/active?key=传入的激活码'>点我激活</a>
     *
     * @param email 邮箱地址
     * @param msg   发送的信息
     * @throws MessagingException s
     */
    public static void activeTemplate(String email, String msg) throws MessagingException {
        messageText.append("<a href='http://localhost:8080/bookstoreweball_war/register/active?key=")
                .append(msg)
                .append("'>点我激活</a>");
        body.put("用户激活", messageText);
        sendEmail(email, body);
    }

    /**
     * 非系统发送邮件，要发送邮件必须要在此方法中调用BaseMailUtils的sendEmail方法，
     * msg为邮箱信息，其格式为一个邮件标题对应一个邮件正文
     * <br>
     * 注意要用BaseMailUtils调用，不能用super
     *
     * @param email 邮箱地址
     * @param msg   邮箱信息：一个邮件标题对应一个邮件正文
     * @throws MessagingException s
     */
    public static void nothingSystemSendMail(String email, Map<String, StringBuilder> msg) throws MessagingException {
        sendEmail(email, msg);
    }
}

