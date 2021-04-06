package com.bu.fpo.container;

import com.bu.fpo.container.interfase.ListContainer;
import com.bu.fpo.obj.Publisher;

import java.util.List;

/**
 * This class created on 2021-04-05
 *
 * @author Elon.Zhang
 */
public class PublisherContainer implements ListContainer<Publisher> {
    
    @Override
    public List<Publisher> getContainer() {
        
        return null;
    }
    
    @Override
    public boolean addMember(Publisher member) {
        
        return false;
    }
    
    @Override
    public boolean removeMember(Publisher member) {
        
        return false;
    }
}
