package com.bu.fpo.dao.interfase;

import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
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
    
    void addNewUser(NormalUser user) throws DataBaseInsertException;
    
    void deleteUser(NormalUser user) throws DatabaseDeleteException;
    
    void modifyUser(NormalUser user) throws DatabaseModifyException;
    
}
