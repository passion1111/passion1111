package testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String home() {
        return  "index222";
    }

    @RequestMapping(value = "/3")
    public String index222(){return "index222";}



    @RequestMapping(value = "/4")
    public String home444() {
        return  "index";
    }
}