package com.bu.fpo.controller;

import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.interfase.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class Homepage {

    @RequestMapping("/Nav2")
    public String Nav2(Model model){
        NormalUser normalUser = new NormalUser();
        normalUser.setUsername("Admin");
        model.addAttribute(normalUser);
        return "/common/Nav2";
    }
    @RequestMapping("/index")
    public String index(Model model){
        NormalUser normalUser = new NormalUser();
        normalUser.setUsername("Admin");
        model.addAttribute(normalUser);
        return "index";
    }
}
