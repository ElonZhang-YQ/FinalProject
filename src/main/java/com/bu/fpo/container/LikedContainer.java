package com.bu.fpo.container;

import com.bu.fpo.container.interfase.MapListContainer;
import com.bu.fpo.exception.EmptyContainerException;
import com.bu.fpo.exception.NullKeyException;
import com.bu.fpo.exception.SameValueException;
import com.bu.fpo.obj.PublishInformation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class created on 2021-04-05
 *
 * @author Elon.Zhang
 */

@Component
public class LikedContainer implements MapListContainer<PublishInformation> {
    
    private static LikedContainer instance;
    
    private Map<String, List<PublishInformation>> likedContainer = new HashMap<String, List<PublishInformation>>();
    
    private LikedContainer() {
    
    }
    
    public static LikedContainer getInstance() {
        if (instance == null) {
            instance = new LikedContainer();
        }
        return instance;
    }
    
    @Override
    public Map<String, List<PublishInformation>> getContainer() {
        
        return likedContainer;
    }
    
    @Override
    public boolean addMember(String key, PublishInformation value) throws SameValueException {
        
        if (isExistKey(key)) {
            if (!isExistValue(key, value)) {
                likedContainer.get(key).add(value);
                return true;
            } else {
                throw new SameValueException();
            }
        } else {
            List<PublishInformation> values = new ArrayList<PublishInformation>();
            values.add(value);
            likedContainer.put(key, values);
        }
        return true;
    }
    
    @Override
    public boolean removeMember(String key, PublishInformation value) throws NullKeyException, EmptyContainerException {
        
        if (isEmpty()) {
            throw new EmptyContainerException();
        }
        if (isExistKey(key)) {
            Iterator<PublishInformation> tem_values = likedContainer.get(key).iterator();
            while (tem_values.hasNext()) {
                PublishInformation info = tem_values.next();
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
    public List<PublishInformation> findMembers(String key) {
        
        return likedContainer.get(key);
    }
    
    @Override
    public boolean isExistKey(String key) {
        
        List<PublishInformation> results = likedContainer.get(key);
        return !results.isEmpty();
    }
    
    @Override
    public boolean isExistValue(String key, PublishInformation value) {
        
        List<PublishInformation> infor = findMembers(key);
        if (!infor.isEmpty()) {
            for (PublishInformation info : infor) {
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
}
