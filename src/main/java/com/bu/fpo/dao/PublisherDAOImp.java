package com.bu.fpo.dao;

import com.bu.fpo.constant.SQLConstant;
import com.bu.fpo.container.PublisherContainer;
import com.bu.fpo.dao.interfase.PublisherDAO;
import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;
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
    public void addNewPublisher(Publisher publisher) throws DataBaseInsertException {
    
        try {
            publisherContainer.addMember(publisher);
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // INSERT_NEW_USER
        int result = jdbcTemplate.update(SQLConstant.INSERT_NEW_USER, publisher.getUserId(), publisher.getUsername(), publisher.getPassword(), publisher.getUserType(), publisher.getPhone(), publisher.getProfile());
        if (result == 0) {
            throw new DataBaseInsertException();
        }
    }
    
    @Override
    public void deletePublisher(String publisherId) throws DatabaseDeleteException {
        
        try {
            Publisher publisher = publisherContainer.getSingleMember(publisherId);
            publisherContainer.removeMember(publisher);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        }
        // TODO delete the data form database
        // DELETE_USER
        int result = jdbcTemplate.update(SQLConstant.DELETE_USER, publisherId);
        if (result == 0) {
            throw new DatabaseDeleteException();
        }
    }
    
    @Override
    public void modifyPublisher(Publisher publisher) throws DatabaseModifyException {
    
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
        int result = jdbcTemplate.update(SQLConstant.MODIFY_USER, publisher.getPassword(), publisher.getPhone(), publisher.getProfile(), publisher.getUserId());
        if (result == 0) {
            throw new DatabaseModifyException();
        }
    }
}
