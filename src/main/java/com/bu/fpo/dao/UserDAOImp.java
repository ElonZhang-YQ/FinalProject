package com.bu.fpo.dao;

import com.bu.fpo.constant.SQLConstant;
import com.bu.fpo.constant.UserType;
import com.bu.fpo.container.LikedContainer;
import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.dao.interfase.UserDAO;
import com.bu.fpo.exception.SameValueException;
import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.interfase.User;
import com.bu.fpo.utils.UserDAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    @Autowired
    private LikedContainer likedContainer;
    
    @Autowired
    private UserDAOUtils userDAOUtils;
    
    @Override
    public List<NormalUser> selectAllUser() {
        
        return userContainer.getContainer();
    }
    
    @Override
    public void addNewUser(NormalUser user) {
        try {
            userContainer.addMember(user);
        } catch (SameValueException e) {
            
        }
    
    
    }
    
    @Override
    public void deleteUser(NormalUser user) {
    
    }
    
    @Override
    public void modifyUser(NormalUser user) {
    
    }
}
