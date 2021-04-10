package com.bu.fpo.obj;

import com.bu.fpo.constant.UserType;
import com.bu.fpo.obj.interfase.User;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public class NormalUser extends User {
    
    public NormalUser() {
        
        super();
    }
    
    // userType = UserType.NORMAL_USER
    
    public NormalUser(String userId, String username, String password, String phone, String profile) {
        
        super(userId, username, password, UserType.NORMAL_USER, phone, profile);
    }
    
    @Override
    public boolean equals(Object obj) {
    
        NormalUser temUser = null;
        if (obj instanceof NormalUser) {
            temUser = (NormalUser) obj;
        }
        if (temUser != null) {
            return temUser.getUserId().equals(this.getUserId()) &&
                    temUser.getUsername().equals(this.getUsername()) &&
                    temUser.getPassword().equals(this.getPassword()) &&
                    temUser.getPhone().equals(this.getPhone()) &&
                    temUser.getUserType() == this.getUserType() &&
                    temUser.getProfile().equals(this.getProfile());
        }
        return false;
    }
}
