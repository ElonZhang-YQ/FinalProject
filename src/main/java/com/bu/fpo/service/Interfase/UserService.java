package com.bu.fpo.service.Interfase;

import com.bu.fpo.obj.NormalUser;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface UserService {
    
    List<NormalUser> findAllUsers();
    
    NormalUser findUserById(String userId);
    
    boolean changeUserProfile(String userId, NormalUser currentUser);
    
    boolean SignUpUser(NormalUser newUser);
    
    boolean removeUser(String deleteUserId, NormalUser deleteUser);

}
