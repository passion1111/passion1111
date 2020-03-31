package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {


    @RequestMapping(value = "/testvalue")
    public String TestValue(HttpServletRequest request){
        String aa=request.getParameter("test");
        System.out.println("aa");

        return ""

    }
}
