package com.bu.fpo.dao.interfase;

import com.bu.fpo.obj.PublishInformation;

import java.util.List;
import java.util.Map;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface PublishInfoDAO {
    
    List<PublishInformation> selectAllPublishInformation();
    
    Map<String, List<String>> selectAllLikedInfo();
    
    Map<String, List<String>> selectAllPublishedInfo();
    
    void addNewPublishInformation(String publisherId, PublishInformation publishInformation);
    
    void deletePublishInformation(String publisherId, PublishInformation publishInformation);
    
    void modifyPublishInformation(PublishInformation publishInformation);
    
    void likedPublishedInformation(String userId, PublishInformation publishedInformation);
    
    void dislikePublishedInformation(String userId, PublishInformation publishedInformation);

}
