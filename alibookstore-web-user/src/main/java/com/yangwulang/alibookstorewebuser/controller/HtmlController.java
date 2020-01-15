package com.yangwulang.alibookstorewebuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangwulang
 */
@Controller
public class HtmlController {
    /**
     * 首页映射
     * @return 首页
     */
    @RequestMapping("/")
    public String getIndex(){
        return "index/index";
    }

    @RequestMapping("/generic.html")
    public String getGeneric(){
        return "index/generic";
    }
    public String getElements(){
        return "index/elements";
    }
    @RequestMapping("/head.html")
    public String getHead(){
        return "index/head";
    }
}
