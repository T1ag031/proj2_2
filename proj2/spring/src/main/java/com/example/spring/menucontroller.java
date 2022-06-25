package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class menucontroller {

    @GetMapping("/verencomendas1")
    public ModelAndView verencs(){
        var mav = new ModelAndView();
        mav.setViewName("verencomendas");
        return mav;
    }

    @GetMapping("/comprar")
    public ModelAndView comprar(){
        var mav = new ModelAndView();
        mav.setViewName("comprar");
        return mav;
    }

    @GetMapping("/terminarsessao")
    public ModelAndView logout(){
        var mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

}
