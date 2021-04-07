package com.bu.fpo.controller;

import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.obj.interfase.User;
import com.bu.fpo.service.Interfase.PublishInformationService;
import com.bu.fpo.service.Interfase.PublisherService;
import com.bu.fpo.service.Interfase.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        User user = publisherService.publisherLogin(name, password);
        HttpSession session = request.getSession();

        if(user != null){
            session.setAttribute("userId",name);
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
    public String doRegister(HttpServletRequest request, Model model){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password_repeat");
        String publisher = request.getParameter("checkbox");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        if (name!=null&& password!=null &&password_repeat!=null&&phone!=null&&email!=null) {
            User user =  userService.findUserById(name);
            if (user == null && password.equals(password_repeat)) {
                if (publisher=="on"){
                Publisher User = new Publisher();
                User.setUsername(name);
                User.setUserType(1);
                User.setPhone(phone);
                User.setProfile(email);
                User.setUserId(name);
                User.setPassword(password);
                publisherService.createNewPublisher(User);
                }else {
                NormalUser User = new NormalUser();
                User.setUsername(name);
                User.setUserType(0);
                User.setPhone(phone);
                User.setProfile(email);
                User.setUserId(name);
                User.setPassword(password);
                userService.SignUpUser(User);
                }
                model.addAttribute("msg","Register success！");
                return "login";}
           else {
                model.addAttribute("msg","Username or password wrong！");
                System.out.println("Username or password wrong！");
                return "register";
            }
        } else {
            model.addAttribute("msg","something is null！");
            System.out.println("Username or password is null！");
            return "register";
        }
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
