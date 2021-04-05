package com.bu.fpo.obj;

import com.bu.fpo.constant.UserType;
import com.bu.fpo.obj.interfase.User;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public class NormalUser extends User {
    
    // userType = UserType.NORMAL_USER
    
    public NormalUser(String userId, String username, String password, String phone, String profile) {
        
        super(userId, username, password, UserType.NORMAL_USER, phone, profile);
    }
}
