package com.bu.fpo.container.interfase;

import com.bu.fpo.exception.values.EmptyContainerException;
import com.bu.fpo.exception.values.NullKeyException;
import com.bu.fpo.exception.values.SameValueException;

import java.util.List;
import java.util.Map;

/**
 * This class created on 2021-04-05
 *
 * @author Elon.Zhang
 */
public interface MapListContainer<T extends String> {

    Map<String, List<T>> getContainer();
    
    boolean addMember(String key, T value) throws SameValueException;
    
    boolean removeMember(String key, T value) throws NullKeyException, EmptyContainerException;
    
    List<T> findMembers(String key);
    
    boolean isExistKey(String key);
    
    boolean isExistValue(String key, T value);
    
    boolean isEmpty();
    
}
