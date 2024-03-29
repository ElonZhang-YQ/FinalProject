package com.bu.fpo.container;

import com.bu.fpo.container.interfase.MapListContainer;
import com.bu.fpo.exception.values.EmptyContainerException;
import com.bu.fpo.exception.values.NullKeyException;
import com.bu.fpo.exception.values.SameValueException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class created on 2021-04-05
 *
 * Key: userId
 * value: List<String> publishInformationId
 *
 * @author Elon.Zhang
 */

@Component
public class LikedContainer implements MapListContainer<String> {
    
    private static LikedContainer instance;
    
    private Map<String, List<String>> likedContainer;
    
    private LikedContainer() {
        likedContainer = new HashMap<String, List<String>>();
    }
    
    public static LikedContainer getInstance() {
        if (instance == null) {
            instance = new LikedContainer();
        }
        return instance;
    }
    
    @Override
    public Map<String, List<String>> getContainer() {
        
        return likedContainer;
    }
    
    @Override
    public boolean addMember(String key, String value) throws SameValueException {
        
        if (isExistKey(key)) {
            if (!isExistValue(key, value)) {
                likedContainer.get(key).add(value);
                return true;
            } else {
                throw new SameValueException();
            }
        } else {
            List<String> values = new ArrayList<String>();
            values.add(value);
            likedContainer.put(key, values);
        }
        return true;
    }
    
    @Override
    public boolean removeMember(String key, String value) throws NullKeyException, EmptyContainerException {
        
        if (isEmpty()) {
            throw new EmptyContainerException();
        }
        if (isExistKey(key)) {
            Iterator<String> tem_values = likedContainer.get(key).iterator();
            while (tem_values.hasNext()) {
                String info = tem_values.next();
                if (info.equals(value)) {
                    tem_values.remove();
                    return true;
                }
            }
        } else {
            throw new NullKeyException();
        }
        return false;
    }
    
    @Override
    public List<String> findMembers(String key) {
        
        return likedContainer.get(key);
    }
    
    @Override
    public boolean isExistKey(String key) {
        
        List<String> results = likedContainer.get(key);
        return !results.isEmpty();
    }
    
    @Override
    public boolean isExistValue(String key, String value) {
        
        List<String> infor = findMembers(key);
        if (!infor.isEmpty()) {
            for (String info : infor) {
                if (info.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        
        if (likedContainer.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public void removeValue(String publishInfoId) {
    
        Iterator<String> keyIterator = likedContainer.keySet().iterator();
        while (keyIterator.hasNext()) {
            List<String> value = likedContainer.get(keyIterator.next());
            Iterator<String> valueIterator = value.iterator();
            while (valueIterator.hasNext()) {
                if (valueIterator.next().equals(publishInfoId)) {
                    valueIterator.remove();
                    break;
                }
            }
        }
    
    }
}
