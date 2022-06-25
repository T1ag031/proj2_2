package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class logincontroller {

    @GetMapping("/voltar")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/logger")
    public String login() {
        /*Cliente userTemp = ClienteBLL.verifyLoginWeb(user);
        if(userTemp != null) {
            return "menucliente";
        }
        else {
            model.addAttribute("erro", "Erro! Dados inválidos");
            return "login";
        }*/
        return "menucliente";
    }
}