package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String page(){
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        var mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    @GetMapping("/registar")
    public ModelAndView register(){
        var mav = new ModelAndView();
        mav.setViewName("registar");
        return mav;
    }
}