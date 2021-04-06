package com.bu.fpo.container.interfase;

import java.util.ArrayList;
import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface ListContainer<T extends Object> {
    
    List<T> getContainer();
    
    boolean addMember(T member);
    
    boolean removeMember(T member);
    
    boolean isExist(T member);
    
    boolean isEmpty();
}
