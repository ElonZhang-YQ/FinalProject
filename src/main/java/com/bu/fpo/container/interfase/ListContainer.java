package com.bu.fpo.container.interfase;

import com.bu.fpo.exception.NullValueException;
import com.bu.fpo.exception.SameValueException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface ListContainer<T extends Object> {
    
    List<T> getContainer();
    
    boolean addMember(T member) throws SameValueException;
    
    boolean removeMember(T member) throws NullValueException;
    
    boolean isExist(T member);
    
    boolean isEmpty();
}
