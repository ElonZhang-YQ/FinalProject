package com.bu.fpo.container;

import com.bu.fpo.container.interfase.ListContainer;
import com.bu.fpo.obj.NormalUser;

import java.util.ArrayList;
import java.util.List;

/**
 * This class created on 2021-04-05
 *
 * @author Elon.Zhang
 */
public class NormalUserContainer implements ListContainer<NormalUser> {
    
    private List<NormalUser> userContainer;
    
    public NormalUserContainer() {
    
    }
    
    public void initialize() {
        
        userContainer = new ArrayList<NormalUser>();
    }
    
    @Override
    public List<NormalUser> getContainer() {
        
        return userContainer;
    }
    
    @Override
    public boolean addMember(NormalUser member) {
        
        return false;
    }
    
    @Override
    public boolean removeMember(NormalUser member) {
        
        return false;
    }
    
    @Override
    public boolean isExist(NormalUser member) {
        
        for () {
        
        }
        return false;
    }
    
    
}
