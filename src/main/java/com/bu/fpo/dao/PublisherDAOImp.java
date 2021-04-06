package com.bu.fpo.dao;

import com.bu.fpo.container.PublisherContainer;
import com.bu.fpo.dao.interfase.PublisherDAO;
import com.bu.fpo.exception.NullValueException;
import com.bu.fpo.exception.SameValueException;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.utils.dao.PublisherDAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */

@Component
public class PublisherDAOImp implements PublisherDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private PublisherContainer publisherContainer;
    
    @Autowired
    private PublisherDAOUtils publisherDAOUtils;
    
    @Override
    public List<Publisher> selectAllPublisher() {
        
        return publisherContainer.getContainer();
    }
    
    @Override
    public Publisher selectSinglePublisher(String publisherId) {
    
        try {
            return publisherContainer.getSingleMember(publisherId);
        } catch (NullValueException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void addNewPublisher(Publisher publisher) {
    
        try {
            publisherContainer.addMember(publisher);
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // TODO add data to database
        // INSERT_NEW_USER
        
    }
    
    @Override
    public void deletePublisher(String publisherId) {
        
        try {
            Publisher publisher = publisherContainer.getSingleMember(publisherId);
            publisherContainer.removeMember(publisher);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        }
        // TODO delete the data form database
        // DELETE_USER
    }
    
    @Override
    public void modifyPublisher(Publisher publisher) {
    
        try {
            Publisher unmodifyPublisher = publisherContainer.getSingleMember(publisher.getUserId());
            publisherContainer.removeMember(unmodifyPublisher);
            publisherContainer.addMember(publisher);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // TODO modify the data fomr the database
        // MODIFY_USER
    }
}
