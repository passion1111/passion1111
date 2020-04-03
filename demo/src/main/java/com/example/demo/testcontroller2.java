package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller2 {

    @RequestMapping("/222")
    public String root_test() throws Exception{
        return "Hello Root(/)";
    }


    @RequestMapping("/2223")
    @ResponseBody
    public String root_test3() throws Exception{

        return "Hello Root(/)";
    }
}
