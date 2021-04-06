package com.bu.fpo.container.interfase;

import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface ListContainer<T extends Object> {
    
    List<T> getContainer();
    
    T getSingleMember(String memberId) throws NullValueException;
    
    boolean addMember(T member) throws SameValueException;
    
    boolean removeMember(T member) throws NullValueException;
    
    boolean isExist(T member);
    
    boolean isEmpty();
    
    boolean addMembers(List<T> members);
}
