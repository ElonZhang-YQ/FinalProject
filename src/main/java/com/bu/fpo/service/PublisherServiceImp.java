package com.bu.fpo.service;

import com.bu.fpo.obj.Publisher;
import com.bu.fpo.service.Interfase.PublisherService;

import java.util.List;

/**
 * This class created on 4/4/2021
 *
 * @author Elon.Zhang
 */
public class PublisherServiceImp implements PublisherService {
    
    @Override
    public List<Publisher> findAllPublisher() {
        
        return null;
    }
    
    @Override
    public Publisher findPublisherById(String publisherId) {
        
        return null;
    }
    
    @Override
    public boolean createNewPublisher(Publisher publisher) {
        
        return false;
    }
    
    @Override
    public boolean changePublisherProfile(String publisherId, Publisher publisher) {
        
        return false;
    }
    
    @Override
    public boolean removePublisher(Publisher publisher) {
        
        return false;
    }
}
