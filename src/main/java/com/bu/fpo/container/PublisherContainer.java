package com.bu.fpo.container;

import com.bu.fpo.container.interfase.ListContainer;
import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;
import com.bu.fpo.obj.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class created on 2021-04-05
 *
 * List<Publisher>
 *
 * @author Elon.Zhang
 */

@Component
public class PublisherContainer implements ListContainer<Publisher> {
    
    private static PublisherContainer instance;
    
    private List<Publisher> publisherContainer;
    
    private PublisherContainer() {
        
        publisherContainer = new ArrayList<Publisher>();
    }
    
    public static PublisherContainer getInstance() {
    
        if (instance == null) {
            instance = new PublisherContainer();
        }
        return instance;
    }
    
    @Override
    public List<Publisher> getContainer() {
        
        return publisherContainer;
    }
    
    @Override
    public Publisher getSingleMember(String memberId) throws NullValueException {
        
        for (Publisher publisher : publisherContainer) {
            if (publisher.getUserId() == memberId) {
                return publisher;
            }
        }
        throw new NullValueException();
    }
    
    @Override
    public boolean addMember(Publisher member) throws SameValueException {
        
        if (isExist(member)) {
            throw new SameValueException();
        }
        publisherContainer.add(member);
        return true;
    }
    
    @Override
    public boolean removeMember(Publisher member) throws NullValueException {
        
        if (isExist(member)) {
            Iterator<Publisher> publisherIter = publisherContainer.iterator();
            while (publisherIter.hasNext()) {
                Publisher temp_user = publisherIter.next();
                if (temp_user.equals(member)) {
                    publisherIter.remove();
                    return true;
                }
            }
        } else {
            throw new NullValueException();
        }
        return false;
    }
    
    @Override
    public boolean isExist(Publisher member) {
        
        for (Publisher publisher : publisherContainer) {
            if (publisher.equals(member)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        
        if (publisherContainer == new ArrayList<Publisher>() || publisherContainer.isEmpty()) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addMembers(List<Publisher> members) {
        
        publisherContainer.addAll(members);
        return true;
    }
}
