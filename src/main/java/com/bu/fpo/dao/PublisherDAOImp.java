package com.bu.fpo.dao;

import com.bu.fpo.container.LikedContainer;
import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.container.PublisherContainer;
import com.bu.fpo.dao.interfase.PublisherDAO;
import com.bu.fpo.exception.NullValueException;
import com.bu.fpo.exception.SameValueException;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.utils.PublisherDAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
    public void addNewPublisher(Publisher publisher) {
    
        try {
            publisherContainer.addMember(publisher);
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // TODO add data to database
        
    }
    
    @Override
    public void deletePublisher(String publisherId) {
        
        try {
            Publisher publisher = publisherContainer.getSingleMember(publisherId);
            publisherContainer.removeMember(publisher);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        }
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
        // TODO 
    }
}
