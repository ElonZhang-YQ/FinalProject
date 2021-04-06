package com.bu.fpo.dao;

import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.dao.interfase.UserDAO;
import com.bu.fpo.obj.NormalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */

@Component
public class UserDAOImp implements UserDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private NormalUserContainer userContainer;
    
    @Override
    public List<NormalUser> selectAllUser() {
        
        if (userContainer.isEmpty()) {
        
        }
        
        return null;
    }
    
    @Override
    public void addNewUser(NormalUser user) {
    
    }
    
    @Override
    public void deleteUser(NormalUser user) {
    
    }
    
    @Override
    public void modifyUser(NormalUser user) {
    
    }
}
