package com.bu.fpo.container;

import java.util.HashMap;
import java.util.Map;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public class MapContainer {
    
    private static Map mapContainer;
    
    private MapContainer() {
    
    }
    
    private static void initialize() {
        
        mapContainer = new HashMap();
    }
    
    public static Map getMapContainer() {
        
        return mapContainer;
    }
    
    // TODO this function need to add exception solution
    public static boolean addMember(String key, Object value) {
        
        mapContainer.put(key, value);
        return true;
    }
    
    public static boolean removeMember(String key, Object value) {
        
        // TODO find the keys list, and remove the value from the list
        
        return true;
    }

}
