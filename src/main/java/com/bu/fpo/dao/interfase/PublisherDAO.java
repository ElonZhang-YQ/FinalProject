package com.bu.fpo.dao.interfase;

import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
import com.bu.fpo.obj.Publisher;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface PublisherDAO {
    
    List<Publisher> selectAllPublisher();
    
    Publisher selectSinglePublisher(String publisherId);
    
    void addNewPublisher(Publisher publisher) throws DataBaseInsertException;
    
    void deletePublisher(String publisherId) throws DatabaseDeleteException;
    
    void modifyPublisher(Publisher publisher) throws DatabaseModifyException;
    
}
