package com.bu.fpo.controller;

import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.obj.interfase.User;
import com.bu.fpo.service.Interfase.PublishInformationService;
import com.bu.fpo.service.Interfase.PublisherService;
import com.bu.fpo.service.Interfase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private PublishInformationService publishInformationService;
    @Autowired
    private UserService userService;

    private Publisher publisher;

    private User User;

    private PublishInformation publishInformation;

    /**
     * Login Interface
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * Determine if login is successful
     * @param request
     * @return
     */
    @RequestMapping("/dologin")
    public String login(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        User user = publisherService.publisherLogin(name, password);
        if(user != null){
            return "index";
        }else{
            return "login";
        }
    }

    /**
     * Registration Interface
     * @return
     */

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * Determine if registration is successful
     * @param request
     */
    @RequestMapping("/doregister")
    public void register(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

    }


    @RequestMapping("/profile")
    public String profile(Model model){
        NormalUser normalUser = new NormalUser();
        model.addAttribute(normalUser);
        return "profile";
    }

    @RequestMapping("/table")
    public String table(Model model){
        NormalUser normalUser = new NormalUser();
        model.addAttribute(normalUser);
        return "table";
    }

}
