package com.bu.fpo.container.interfase;

import java.util.HashMap;
import java.util.Map;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface MapContainer<T extends Object> {
    
    Map<String, T> getContainer();
    
    boolean addMember(String key, T value);
    
    boolean removeMember(String key, T value);
    
    T findMember(String key);
    
    boolean isExist(String key);

}
