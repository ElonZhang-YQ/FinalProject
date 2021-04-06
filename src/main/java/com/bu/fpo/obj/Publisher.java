package com.bu.fpo.obj;

import com.bu.fpo.constant.UserType;
import com.bu.fpo.obj.interfase.User;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public class Publisher extends User {
    
    public Publisher() {
        
        super();
    }
    
    // userType = UserType.PUBLISHER
    
    public Publisher(String userId, String username, String password, String phone, String profile) {
        
        super(userId, username, password, UserType.PUBLISHER, phone, profile);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        Publisher temUser = null;
        if (obj instanceof Publisher) {
            temUser = (Publisher) obj;
        }
        if (temUser != null) {
            return temUser.getUserId() == this.getUserId() &&
                    temUser.getUsername() == this.getUsername() &&
                    temUser.getPassword() == this.getPassword()&&
                    temUser.getPhone() == this.getPhone() &&
                    temUser.getUserType() == this.getUserType() &&
                    temUser.getProfile() == this.getProfile();
        }
        return false;
    }
}
