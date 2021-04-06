package com.bu.fpo.container;

import com.bu.fpo.container.interfase.ListContainer;
import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;
import com.bu.fpo.obj.NormalUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This class created on 2021-04-05
 *
 * List<NormalUser>
 *
 * @author Elon.Zhang
 */

@Component
public class NormalUserContainer implements ListContainer<NormalUser> {
    
    private static NormalUserContainer instance;
    
    private List<NormalUser> userContainer;
    
    private NormalUserContainer() {
        userContainer = new ArrayList<NormalUser>();
    }
    
    public static NormalUserContainer getInstance() {
    
        if (instance == null) {
            instance = new NormalUserContainer();
        }
        return instance;
    }
    
    @Override
    public List<NormalUser> getContainer() {
        
        return userContainer;
    }
    
    @Override
    public NormalUser getSingleMember(String memberId) throws NullValueException {
    
        for (NormalUser user : userContainer) {
            if (user.getUserId() == memberId) {
                return user;
            }
        }
        throw new NullValueException();
    }
    
    @Override
    public boolean addMember(NormalUser member) throws SameValueException {
    
        if (isExist(member)) {
            throw new SameValueException();
        }
        userContainer.add(member);
        return true;
    }
    
    @Override
    public boolean removeMember(NormalUser member) throws NullValueException {
    
        if (isExist(member)) {
            Iterator<NormalUser> userIter = userContainer.iterator();
            while (userIter.hasNext()) {
                NormalUser temp_user = userIter.next();
                if (temp_user.equals(member)) {
                    userIter.remove();
                    return true;
                }
            }
        } else {
            throw new NullValueException();
        }
        return false;
    }
    
    @Override
    public boolean isExist(NormalUser member) {
    
        for (NormalUser user : userContainer) {
            if (user.equals(member)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
     
        if (userContainer == new ArrayList<NormalUser>() || userContainer.isEmpty()) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addMembers(List<NormalUser> members) {
        
        userContainer.addAll(members);
        return true;
    }
    
    
}
