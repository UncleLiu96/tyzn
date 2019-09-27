package com.spray.project.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/18 0018 16:37
 * @desc TODO
 */
//@Controller
public class LoginController {

//    @GetMapping("/")
    public String login(){
        return "login";
    }
}
