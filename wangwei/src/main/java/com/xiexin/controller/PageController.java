package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {  // /page/studentlist
    @RequestMapping("/sessionLoglist")
    public String sessionLoglist(){
        return "sessionLoglist";
    }


    @RequestMapping("/sysLoglist")
    public String sysLoglist(){
        return "sysLoglist";
    }

}
