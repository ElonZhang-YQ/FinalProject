package com.bu.fpo.action;

import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.obj.NormalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class created on 2021-04-05
 *
 * @author Each.Zhang
 */

@RestController
@RequestMapping("/user")
public class UserAction {
    
    @Autowired
    private NormalUserContainer container;
    
    @RequestMapping("/list")
    public List<NormalUser> getUsers() {
        
        return container.getContainer();
    }
    
    
}
