package com.bu.fpo.service;

import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.service.Interfase.UserService;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public class UserServiceImp implements UserService {
    
    @Override
    public List<NormalUser> findAllUsers() {
        
        return null;
    }
    
    @Override
    public NormalUser findUserById(String userId) {
        
        return null;
    }
    
    @Override
    public boolean changeUserProfile(String userId, NormalUser currentUser) {
        
        return false;
    }
    
    @Override
    public boolean SignUpUser(NormalUser newUser) {
        
        return false;
    }
    
    @Override
    public boolean removeUser(NormalUser deleteUser) {
        
        return false;
    }
}
