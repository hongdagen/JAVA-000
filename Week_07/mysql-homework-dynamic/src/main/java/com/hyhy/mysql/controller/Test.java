package com.hyhy.mysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: hyhy
 * @Date: 2020/12/1 9:29 下午
 */

@Controller
public class Test {

    @RequestMapping("/test")
    public String test(){
        return "aaa";
    }
}
