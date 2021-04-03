package com.bu.fpo.dao;

import com.bu.fpo.dao.interfase.UserDAO;
import com.bu.fpo.obj.NormalUser;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public class UserDAOImp implements UserDAO {
    
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
