package com.bu.fpo.dao.interfase;

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
    
    void addNewPublisher(Publisher publisher);
    
    void deletePublisher(String publisherId);
    
    void modifyPublisher(Publisher publisher);
    
}
