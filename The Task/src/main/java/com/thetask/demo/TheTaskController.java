package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheTaskController {

    @GetMapping("/login")
    String getStart() {
        return "loginPage";
    }
}
