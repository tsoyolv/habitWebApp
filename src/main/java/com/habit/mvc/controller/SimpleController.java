package com.habit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * OLTS on 28.12.2016.
 */
@Controller
public class SimpleController {

    @RequestMapping(value = "/loginmvc", method = RequestMethod.GET)
    public String hello() {
        return "home";
    }
}
