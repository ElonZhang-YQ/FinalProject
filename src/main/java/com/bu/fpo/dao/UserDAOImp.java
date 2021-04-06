package com.bu.fpo.dao;

import com.bu.fpo.constant.SQLConstant;
import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.dao.interfase.UserDAO;
import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;
import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.utils.dao.UserDAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */

@Component
public class UserDAOImp implements UserDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private NormalUserContainer userContainer;
    
    @Override
    public List<NormalUser> selectAllUser() {
        
        return userContainer.getContainer();
    }
    
    @Override
    public NormalUser selectSingleUser(String userId) {
    
        try {
            return userContainer.getSingleMember(userId);
        } catch (NullValueException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void addNewUser(NormalUser user) throws DataBaseInsertException {
        try {
            userContainer.addMember(user);
        } catch (SameValueException e) {
            e.printStackTrace();
        }
        // INSERT_NEW_USER
        int result = jdbcTemplate.update(SQLConstant.INSERT_NEW_USER, user.getUserId(), user.getUsername(), user.getPassword(), user.getUserType(), user.getPhone(), user.getProfile());
        if (result == 0) {
            throw new DataBaseInsertException();
        }
    }
    
    @Override
    public void deleteUser(NormalUser user) throws DatabaseDeleteException {
        try {
            userContainer.removeMember(user);
        } catch (NullValueException e) {
            e.printStackTrace();
        }
        // DELETE_USER
        int result = jdbcTemplate.update(SQLConstant.DELETE_USER, user.getUserId());
        if (result == 0) {
            throw new DatabaseDeleteException();
        }
    }
    
    @Override
    public void modifyUser(NormalUser user) throws DatabaseModifyException {
        
        try {
            NormalUser unModifyUser = userContainer.getSingleMember(user.getUserId());
            userContainer.removeMember(unModifyUser);
            userContainer.addMember(user);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // MODIFY_USER
        int result = jdbcTemplate.update(SQLConstant.MODIFY_USER, user.getPassword(), user.getPhone(), user.getProfile(), user.getUserId());
        if (result == 0) {
            throw new DatabaseModifyException();
        }
    }
}
