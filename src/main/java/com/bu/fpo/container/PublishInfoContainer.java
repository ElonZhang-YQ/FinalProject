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
public class PublishInfoContainer implements MapListContainer<PublishInformation> {
    
    private static PublishInfoContainer instance;
    
    private Map<String, List<PublishInformation>> publishInfoContainer;
    
    private PublishInfoContainer() {
    
    }
    
    public static PublishInfoContainer getInstance() {
    
        if (instance == null) {
            instance = new PublishInfoContainer();
        }
        return instance;
    }
    
    @Override
    public Map<String, List<PublishInformation>> getContainer() {
        
        return publishInfoContainer;
    }
    
    @Override
    public boolean addMember(String key, PublishInformation value) throws SameValueException {
    
        if (isExistKey(key)) {
            if (!isExistValue(key, value)) {
                publishInfoContainer.get(key).add(value);
                return true;
            } else {
                throw new SameValueException();
            }
        } else {
            List<PublishInformation> values = new ArrayList<PublishInformation>();
            values.add(value);
            publishInfoContainer.put(key, values);
        }
        return true;
    }
    
    @Override
    public boolean removeMember(String key, PublishInformation value) throws EmptyContainerException, NullKeyException {
    
        if (isEmpty()) {
            throw new EmptyContainerException();
        }
        if (isExistKey(key)) {
            Iterator<PublishInformation> tem_values = publishInfoContainer.get(key).iterator();
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
        
        return publishInfoContainer.get(key);
    }
    
    @Override
    public boolean isExistKey(String key) {
    
        List<PublishInformation> results = publishInfoContainer.get(key);
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
    
        if (publishInfoContainer.isEmpty()) {
            return true;
        }
        return false;
    }
}
