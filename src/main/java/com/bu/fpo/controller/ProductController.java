package com.bu.fpo.controller;

import com.bu.fpo.exception.values.NullValueException;
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
import org.springframework.web.bind.support.SessionStatus;

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
    
    
    /**
     * Login Interface
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        
        return "login";
    }
    
    /**
     * Determine if login is successful
     *
     * @param request
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, Model model) {
        
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String publisher = request.getParameter("checkbox");
        User user;
        if (publisher != null && publisher.equals("on")) {
            user = publisherService.publisherLogin(name, password);
            if (user == null) {
                model.addAttribute("msg", "Failed, You are not a publisher");
                return "forward:login";
            }
        } else {
            user = userService.normalUserLogin(name, password);
            if (user == null) {
                model.addAttribute("msg", "Failed, You are a publisher");
                return "forward:login";
            }
        }
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("userId", name);
            session.setAttribute("usertype", user.getUserType());
            session.setMaxInactiveInterval(500);
            return "index";
        } else {
            model.addAttribute("msg", "Failed, Doesn't exit");
            return "forward:login";
        }
    }
    
    /**
     * Registration Interface
     *
     * @return
     */
    
    @RequestMapping("/register")
    public String register() {
        
        return "register";
    }
    
    /**
     * Determine if registration is successful
     *
     * @param request
     */
    @RequestMapping("/getRegister")
    public String getRegister(HttpServletRequest request, Model model) {
        
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password_repeat");
        String publisher = request.getParameter("checkbox");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        if (name != null && password != null && password_repeat != null && phone != null && email != null) {
            User user = null;
            User pUser = null;
            try {
                user = userService.findUserById(name);
                pUser = publisherService.findPublisherById(name);
            } catch (Exception e) {
            
            }
            if (pUser == null && user == null && password.equals(password_repeat)) {
                if (publisher.equals("on")) {
                    Publisher User = new Publisher();
                    User.setUsername(name);
                    User.setUserType(1);
                    User.setPhone(phone);
                    User.setProfile(email);
                    User.setUserId(name);
                    User.setPassword(password);
                    publisherService.createNewPublisher(User);
                } else {
                    NormalUser User = new NormalUser();
                    User.setUsername(name);
                    User.setUserType(0);
                    User.setPhone(phone);
                    User.setProfile(email);
                    User.setUserId(name);
                    User.setPassword(password);
                    userService.SignUpUser(User);
                }
                model.addAttribute("msg", "Register success！");
                return "forward:login";
            } else {
                model.addAttribute("msg", "Username or password wrong！or Username is taken");
                return "forward:register";
            }
        } else {
            model.addAttribute("msg", "something is null！");
            return "forward:register";
        }
    }
    
    
    @RequestMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {
        
        HttpSession session = request.getSession();
        String username = "Guest";
        Integer usertype;
        String phone = "1234567890";
        String email = "user@example.com";
        User user;
        if (session != null) {
            username = (String) session.getAttribute("userId");
            usertype = (Integer) session.getAttribute("usertype");
            if (usertype != null && username != null) {
                if (usertype == 0) {
                    user = userService.findUserById(username);
                } else {
                    user = publisherService.findPublisherById(username);
                }
                phone = user.getPhone();
                email = user.getProfile();
            }
        }
        model.addAttribute("username", username);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        return "profile";
    }
    
    @RequestMapping("/changePhone")
    public String changePhone(HttpServletRequest request, Model model) {
        
        HttpSession session = request.getSession();
        User user;
        String username;
        Integer usertype;
        String phone = request.getParameter("phone");
        username = (String) session.getAttribute("userId");
        System.out.println(phone);
        usertype = (Integer) session.getAttribute("usertype");
        if (usertype != null && username != null) {
            
            if (usertype == 0) {
                user = userService.findUserById(username);
                user.setPhone(phone);
                userService.changeUserProfile(username, (NormalUser) user);
            } else {
                user = publisherService.findPublisherById(username);
                user.setPhone(phone);
                publisherService.changePublisherProfile(username, (Publisher) user);
            }
        }
        return "redirect:profile";
    }
    
    @RequestMapping("/changeEmail")
    public String changeEmail(HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        User user;
        String username;
        Integer usertype;
        String email = request.getParameter("email");
        username = (String) session.getAttribute("userId");
        System.out.println(email);
        
        usertype = (Integer) session.getAttribute("usertype");
        if (usertype != null && username != null) {
            
            if (usertype == 0) {
                user = userService.findUserById(username);
                user.setProfile(email);
                userService.changeUserProfile(username, (NormalUser) user);
            } else {
                user = publisherService.findPublisherById(username);
                user.setProfile(email);
                publisherService.changePublisherProfile(username, (Publisher) user);
            }
            
        }
        
        return "redirect:profile";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/login";
    }
    
    
}
