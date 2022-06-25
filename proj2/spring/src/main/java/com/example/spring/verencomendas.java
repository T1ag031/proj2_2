package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class verencomendas {

    @GetMapping("/encs")
    public String page(){
        return "verencomendas";
    }

    @RequestMapping("/menucliente")
    public String index(Model model) {
        return "menucliente";
    }


}
