package com.bu.fpo.dao.interfase;

import com.bu.fpo.obj.NormalUser;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface UserDAO {
    
    List<NormalUser> selectAllUser();
    
    NormalUser selectSingleUser(String userId);
    
    void addNewUser(NormalUser user);
    
    void deleteUser(NormalUser user);
    
    void modifyUser(NormalUser user);
    
}
