package com.tyzn.project.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/18 0018 16:39
 * @desc TODO
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index(){
        return "index";
    }
}
