package com.bu.fpo.container;

import com.bu.fpo.container.interfase.MapListContainer;
import com.bu.fpo.exception.EmptyContainerException;
import com.bu.fpo.exception.NullKeyException;
import com.bu.fpo.exception.SameValueException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class created on 2021-04-05
 *
 * Key: publisherId
 * value: List<String> publishInformationId
 *
 * @author Elon.Zhang
 */

@Component
public class PublisherInfomationContainer implements MapListContainer<String> {
    
    private static PublisherInfomationContainer instance;
    
    private Map<String, List<String>> publishInfoContainer;
    
    private PublisherInfomationContainer() {
    
        publishInfoContainer = new HashMap<String, List<String>>();
    }
    
    public static PublisherInfomationContainer getInstance() {
    
        if (instance == null) {
            instance = new PublisherInfomationContainer();
        }
        return instance;
    }
    
    @Override
    public Map<String, List<String>> getContainer() {
        
        return publishInfoContainer;
    }
    
    @Override
    public boolean addMember(String key, String value) throws SameValueException {
    
        if (isExistKey(key)) {
            if (!isExistValue(key, value)) {
                publishInfoContainer.get(key).add(value);
                return true;
            } else {
                throw new SameValueException();
            }
        } else {
            List<String> values = new ArrayList<String>();
            values.add(value);
            publishInfoContainer.put(key, values);
        }
        return true;
    }
    
    @Override
    public boolean removeMember(String key, String value) throws EmptyContainerException, NullKeyException {
    
        if (isEmpty()) {
            throw new EmptyContainerException();
        }
        if (isExistKey(key)) {
            Iterator<String> tem_values = publishInfoContainer.get(key).iterator();
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
        
        return publishInfoContainer.get(key);
    }
    
    @Override
    public boolean isExistKey(String key) {
    
        List<String> results = publishInfoContainer.get(key);
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
    
        if (publishInfoContainer.isEmpty()) {
            return true;
        }
        return false;
    }
}
