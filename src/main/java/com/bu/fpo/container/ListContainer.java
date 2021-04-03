package com.bu.fpo.container;

import java.util.ArrayList;
import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public class ListContainer {
    
    private static List container;
    
    private ListContainer() {
    
    }
    
    private static void initialize() {
        container = new ArrayList();
    }
    
    public static List getContainer() {
        
        return container;
    }
    
    // TODO this function need to add exception solution
    public static boolean addMember(Object member) {
        
        container.add(member);
        return true;
    }
    
    public static boolean removeMember(Object member) {
    
        // remove is not work, iterator could be use in this function
        return true;
    }
    
    
    
    
}
