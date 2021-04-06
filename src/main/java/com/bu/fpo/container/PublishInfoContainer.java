package com.bu.fpo.container;

import com.bu.fpo.container.interfase.MapListContainer;
import com.bu.fpo.obj.PublishInformation;

import java.util.List;
import java.util.Map;

/**
 * This class created on 2021-04-05
 *
 * @author Elon.Zhang
 */
public class PublishInfoContainer implements MapListContainer<PublishInformation> {
    
    @Override
    public Map<String, List<PublishInformation>> getContainer() {
        
        return null;
    }
    
    @Override
    public boolean addMember(String key, PublishInformation value) {
        
        return false;
    }
    
    @Override
    public boolean removeMember(String key, PublishInformation value) {
        
        return false;
    }
}
