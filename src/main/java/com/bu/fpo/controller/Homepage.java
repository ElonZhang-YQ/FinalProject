package com.bu.fpo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller

public class Homepage {

    @RequestMapping("/Nav2")
    public String Nav2(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String username;
        if (session!=null){
            username = (String) session.getAttribute("userId");
        }
        else {
            username = "Guest";
        }
        model.addAttribute("username",username);
        return "/common/Nav2";
    }
    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String username;
        if (session!=null){
            username = (String) session.getAttribute("userId");
        }
        else {
            username = "Guest";
        }
        model.addAttribute("username",username);
        return "index";
    }
}
