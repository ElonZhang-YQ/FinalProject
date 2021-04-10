package com.bu.fpo.container;

import com.bu.fpo.container.interfase.ListContainer;
import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;
import com.bu.fpo.obj.PublishInformation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class created on 4/6/2021
 *
 * @author Elon.Zhang
 */

@Component
public class PublishedContainer implements ListContainer<PublishInformation> {
    
    private static PublishedContainer instance;
    
    private List<PublishInformation> publishedContainer;
    
    private PublishedContainer() {
        publishedContainer = new ArrayList<PublishInformation>();
    }
    
    public static PublishedContainer getInstance() {
        
        if (instance == null) {
            instance = new PublishedContainer();
        }
        return instance;
    }
    
    @Override
    public List<PublishInformation> getContainer() {
        
        return publishedContainer;
    }
    
    @Override
    public PublishInformation getSingleMember(String memberId) throws NullValueException {
    
        for (PublishInformation info : publishedContainer) {
            if (info.getPublishInfoId().equals(memberId)) {
                return info;
            }
        }
        throw new NullValueException();
    }
    
    @Override
    public boolean addMember(PublishInformation member) throws SameValueException {
        
        if (isExist(member)) {
            throw new SameValueException();
        }
        publishedContainer.add(member);
        return true;
    }
    
    @Override
    public boolean removeMember(PublishInformation member) throws NullValueException {
        
        if (isExist(member)) {
            Iterator<PublishInformation> publishInfoIter = publishedContainer.iterator();
            while (publishInfoIter.hasNext()) {
                PublishInformation temp_user = publishInfoIter.next();
                if (temp_user.equals(member)) {
                    publishInfoIter.remove();
                    return true;
                }
            }
        } else {
            throw new NullValueException();
        }
        return false;
    }
    
    @Override
    public boolean isExist(PublishInformation member) {
        
        for (PublishInformation publishInfo : publishedContainer) {
            if (publishInfo.equals(member)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        
        if (publishedContainer == new ArrayList<PublishInformation>() || publishedContainer.isEmpty()) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addMembers(List<PublishInformation> publishedInfo) {
    
        publishedContainer.addAll(publishedInfo);
        return true;
    }
}
