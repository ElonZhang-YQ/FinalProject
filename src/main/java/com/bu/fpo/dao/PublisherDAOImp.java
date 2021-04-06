package com.bu.fpo.dao;

import com.bu.fpo.container.LikedContainer;
import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.dao.interfase.PublisherDAO;
import com.bu.fpo.obj.Publisher;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */

@Component
public class PublisherDAOImp implements PublisherDAO {
    
    
    
    @Override
    public List<Publisher> selectAllPublisher() {
        
        return null;
    }
    
    @Override
    public void addNewPublisher(Publisher publisher) {
    
    }
    
    @Override
    public void deletePublisher(String publisherId) {
    
    }
    
    @Override
    public void modifyPublisher(Publisher publisher) {
    
    }
}
