package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testcontroller {

    @RequestMapping(value = "/")
    public String test(Model model) {
        model.addAttribute("test", "string");
        return "home";
    }

    @RequestMapping("/jsp")
    public String jsp() throws Exception {
        return "home";
    }


    @RequestMapping("/HelloWorld")

    public ModelAndView firstPage() {
        return new ModelAndView("helloworld");
    }


}
