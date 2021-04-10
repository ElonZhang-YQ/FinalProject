package com.bu.fpo.utils.service;

import com.bu.fpo.obj.interfase.User;

import java.util.List;

/**
 * This class created on 4/6/2021
 *
 * @author Elon.Zhang
 */
public class UserServiceUtils {
    
    public static User userLogin(String userName, String password, List findedUsers) {
        
        for (Object findedUser : findedUsers) {
            if (findedUser instanceof User) {
                User currentUser = (User) findedUser;
                if (currentUser.getUsername().equals(userName) && currentUser.getPassword().equals(password)) {
                    return currentUser;
                }
            }
        }
        return null;
    }
    
}
