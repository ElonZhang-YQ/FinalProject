package com.bu.fpo.controller;

import com.bu.fpo.obj.Page;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.service.Interfase.PublishInformationService;
import com.bu.fpo.service.Interfase.PublisherService;
import com.bu.fpo.service.Interfase.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class TableController {
    
    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private PublishInformationService publishInformationService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/table")
    public String table(Model model, Page page) {
        
        List<PublishInformation> list = publishInformationService.findAllPublishInformation();
        Integer limit = 10;
        page.setLimit(limit);
        
        page.setRows(list.size());
        List<PublishInformation> showList = new ArrayList<PublishInformation>();
        if (!list.isEmpty()) {
            showList = list.subList(page.getOffset(), page.getLimit());
        }
        model.addAttribute(page);
        model.addAttribute("list", showList);
        return "table";
    }
    
    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        Integer usertype = (Integer) session.getAttribute("usertype");
        if (usertype != null && usertype != 0) {
            String companyName = request.getParameter("companyName");
            String position = request.getParameter("position");
            String location = request.getParameter("location");
            String requirement = request.getParameter("requirement");
            String salary = request.getParameter("salary");
            String publisher = (String) session.getAttribute("userId");
            PublishInformation publishInformation = new PublishInformation();
            String publishInformationID = String.valueOf(publishInformationService.findAllPublishInformation().size() + 1);
            publishInformation.setSalary(salary);
            publishInformation.setRequirement(requirement);
            publishInformation.setLocation(location);
            publishInformation.setProfile(position);
            publishInformation.setTitle(companyName);
            publishInformation.setPublishInfoId(publishInformationID);
            publishInformationService.publishInfo(publisher, publishInformation);
            return "redirect:table";
        } else {
            model.addAttribute("msg", "Failed, You are not a publisher");
            return "forward:table";
        }
        
    }
    
    @RequestMapping("/del/{id}")
    public String del(Model model, HttpServletRequest request, @PathVariable String id) {
        
        HttpSession session = request.getSession();
        String publisher = (String) session.getAttribute("userId");
        if (publisher != null) {
            if (publishInformationService.cancelPublishedInfo(publisher, id)) {
                return "redirect:/table";
            } else {
                model.addAttribute("msg", "Failed, You are not owner");
                return "forward:table";
            }
        } else {
            model.addAttribute("msg", "Failed, You are not LOGIN");
            return "forward:table";
        }
        
    }
    
    
    @RequestMapping("/alt/{id}")
    public String alt(Model model, @PathVariable String id) {
        
        return "table";
    }
    
    
    @RequestMapping("/search")
    public String search(Model model) {
        
        List<PublishInformation> list = publishInformationService.findAllPublishInformation();
        model.addAttribute("list", list);
        return "redirect:table";
    }
    
}
