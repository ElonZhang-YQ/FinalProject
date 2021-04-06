package com.bu.fpo.dao.interfase;

import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
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
    
    void addNewPublishInformation(String publisherId, PublishInformation publishInformation) throws DataBaseInsertException;
    
    void deletePublishInformation(String publisherId, PublishInformation publishInformation) throws DatabaseDeleteException;
    
    void modifyPublishInformation(PublishInformation publishInformation) throws DatabaseModifyException;
    
    void likedPublishedInformation(String userId, PublishInformation publishedInformation) throws DataBaseInsertException;
    
    void dislikePublishedInformation(String userId, PublishInformation publishedInformation) throws DatabaseDeleteException;

}
