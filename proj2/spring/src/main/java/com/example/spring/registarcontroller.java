package com.example.spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class registarcontroller {
    @GetMapping("/voltar1")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/register")
    public String registar(
    ) {
        /*Cliente userTemp = ClienteBLL.verifyLoginWeb(user);
        if(userTemp != null) {
            return "redirect:/menucliente";
        }
        else {
            model.addAttribute("erro", "Erro! Dados inválidos");
            return "login";
        }*/
        return "index";
    }
}
