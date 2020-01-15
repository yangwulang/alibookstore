package com.yangwulang.utils;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要放行的静态资源
 *
 * @author yangwulang
 */
public class FilterListUtils {
    private static List<String> fieldList = new ArrayList<>();
    private static FilterListUtils instance = new FilterListUtils();

    private FilterListUtils() {

    }

    static {
        fieldList.add("/index.jsp");
        fieldList.add("/activeSuccess.jsp");
        fieldList.add("/BookTable.jsp");
        fieldList.add("/NoticeTable.jsp");
        fieldList.add("/UserTable.jsp");
        fieldList.add("/registerSuccess.jsp");
        fieldList.add("/self_info.jsp");
        fieldList.add("/booklist.jsp");
        fieldList.add("/login.jsp");
        fieldList.add("/register.jsp");
        fieldList.add("/searchAllNotice");
        fieldList.add("/searchBookForAdmin");
        fieldList.add("/searchAll");
        fieldList.add("/fuzzySearch");
        fieldList.add("/MenuSearch");
        fieldList.add("/update");
        fieldList.add("/add");
        fieldList.add("/login");
        fieldList.add("/register");
        fieldList.add("/active");
        fieldList.add("/delete");
        fieldList.add("/signout");
        fieldList.add(".css");
        fieldList.add(".png");
        fieldList.add(".js");
        fieldList.add(".scss");
        fieldList.add(".ttf");
        fieldList.add(".woff");
        fieldList.add(".svg");
        fieldList.add(".woff2");
        fieldList.add(".otf");
        fieldList.add(".map");
    }

    /**
     * 实例化FilterUtils
     *
     * @return FilterUtils的实例
     */
    public static FilterListUtils getInstance() {
        return instance;
    }

    public static String getTrueIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || "".equals(ip.trim()) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || "".equals(ip.trim()) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || "".equals(ip.trim()) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }
}
