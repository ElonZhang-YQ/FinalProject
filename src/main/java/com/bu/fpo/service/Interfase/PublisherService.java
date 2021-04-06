package com.bu.fpo.service.Interfase;

import com.bu.fpo.obj.Publisher;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface PublisherService {

    List<Publisher> findAllPublisher();
    
    Publisher findPublisherById(String publisherId);

    Publisher publisherLogin(String username, String password);
    
    boolean createNewPublisher(Publisher publisher);
    
    boolean changePublisherProfile(String publisherId, Publisher publisher);
    
    boolean removePublisher(String deletePublisherId, Publisher publisher);

}
