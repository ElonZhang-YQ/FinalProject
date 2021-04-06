package com.bu.fpo.dao;

import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.dao.interfase.UserDAO;
import com.bu.fpo.obj.NormalUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */

@Component
public class UserDAOImp implements UserDAO {
    
    private static UserDAO instance;
    
    private NormalUserContainer userContainer = NormalUserContainer.getInstance();
    
    private void UserDAO () {
    
    }
    
    public static UserDAO getInstance() {
    
        if (instance == null) {
            instance = new UserDAOImp();
        }
        return instance;
    }
    
    @Override
    public List<NormalUser> selectAllUser() {
        
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
