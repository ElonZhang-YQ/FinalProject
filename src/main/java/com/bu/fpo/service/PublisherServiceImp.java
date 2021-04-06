package com.bu.fpo.service;

import com.bu.fpo.dao.interfase.PublisherDAO;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.service.Interfase.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class created on 4/4/2021
 *
 * @author Elon.Zhang
 */

@Service
public class PublisherServiceImp implements PublisherService {
    
    @Autowired
    private PublisherDAO publisherDAO;
    
    @Override
    public List<Publisher> findAllPublisher() {
        
        return publisherDAO.selectAllPublisher();
    }
    
    /**
     * If u use this function, must take null value check!!!!!!!!!
     * @param publisherId
     * @return
     */
    @Override
    public Publisher findPublisherById(String publisherId) {
        
        return publisherDAO.selectSinglePublisher(publisherId);
    }

    /**
     * must take null value check.
     * @param username
     * @param password
     * @return
     */
    @Override
    public Publisher publisherLogin(String username, String password) {

        List<Publisher> publishers = publisherDAO.selectAllPublisher();
        for (Publisher publisher : publishers) {
            if (publisher.getUsername() == username && publisher.getPassword() == password) {
                return publisher;
            }
        }
        return null;
    }

    @Override
    public boolean createNewPublisher(Publisher publisher) {
        
        publisherDAO.addNewPublisher(publisher);
        return false;
    }
    
    @Override
    public boolean changePublisherProfile(String publisherId, Publisher publisher) {
        
        if (findPublisherById(publisherId) == null) {
            return false;
        }
        publisherDAO.modifyPublisher(publisher);
        return true;
    }
    
    @Override
    public boolean removePublisher(String deletePublisherId, Publisher publisher) {
        
        if (findPublisherById(deletePublisherId) == null) {
            return false;
        }
        publisherDAO.deletePublisher(deletePublisherId);
        return false;
    }
}
