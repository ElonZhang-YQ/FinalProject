package com.bu.fpo.service;

import com.bu.fpo.dao.interfase.PublisherDAO;
import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.service.Interfase.PublisherService;
import com.bu.fpo.utils.service.UserServiceUtils;
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
        return (Publisher) UserServiceUtils.userLogin(username, password, publishers);
    }

    @Override
    public boolean createNewPublisher(Publisher publisher) {
    
        try {
            publisherDAO.addNewPublisher(publisher);
            return true;
        } catch (DataBaseInsertException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean changePublisherProfile(String publisherId, Publisher publisher) {
        
        if (findPublisherById(publisherId) == null) {
            return false;
        }
        try {
            publisherDAO.modifyPublisher(publisher);
            return true;
        } catch (DatabaseModifyException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean removePublisher(String deletePublisherId, Publisher publisher) {
        
        if (findPublisherById(deletePublisherId) == null) {
            return false;
        }
        try {
            publisherDAO.deletePublisher(deletePublisherId);
            return true;
        } catch (DatabaseDeleteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
