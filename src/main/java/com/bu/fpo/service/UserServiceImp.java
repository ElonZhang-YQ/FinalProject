package com.bu.fpo.service;

import com.bu.fpo.dao.interfase.UserDAO;
import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.service.Interfase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
@Service
public class UserServiceImp implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public List<NormalUser> findAllUsers() {
        
        return userDAO.selectAllUser();
    }
    
    /**
     * @Attention
     * If someone use this function, u must take null value check.
     * If the function has null value exception, it will return a null value.
     * @param userId
     * @return
     */
    @Override
    public NormalUser findUserById(String userId) {
        
        return userDAO.selectSingleUser(userId);
    }

    /**
     * If anyone use this function, must take null value check.
     * @param username
     * @param password
     * @return
     */
    @Override
    public NormalUser normalUserLogin(String username, String password) {

        List<NormalUser> normalUsers = userDAO.selectAllUser();
        for (NormalUser user : normalUsers) {
            if (user.getUsername() == username && user.getPassword() == password) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean changeUserProfile(String userId, NormalUser currentUser) {
    
        if (findUserById(userId) == null) {
            return false;
        }
        userDAO.modifyUser(currentUser);
        return true;
    }
    
    @Override
    public boolean SignUpUser(NormalUser newUser) {
        
        userDAO.addNewUser(newUser);
        return true;
    }
    
    @Override
    public boolean removeUser(String deleteUserId, NormalUser deleteUser) {
        if (findUserById(deleteUserId) == null) {
            return false;
        }
        userDAO.deleteUser(deleteUser);
        return true;
    }
}
