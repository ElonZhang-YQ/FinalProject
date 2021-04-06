package com.bu.fpo.dao;

import com.bu.fpo.container.LikedContainer;
import com.bu.fpo.container.PublishedContainer;
import com.bu.fpo.container.PublisherInformationContainer;
import com.bu.fpo.dao.interfase.PublishInfoDAO;
import com.bu.fpo.exception.EmptyContainerException;
import com.bu.fpo.exception.NullKeyException;
import com.bu.fpo.exception.NullValueException;
import com.bu.fpo.exception.SameValueException;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.utils.dao.PublishInfoDAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */

@Component
public class PublishInfoDAOImp implements PublishInfoDAO {
    
    @Autowired
    private LikedContainer likedContainer;
    
    @Autowired
    private PublisherInformationContainer publisherInfoContainer;
    
    @Autowired
    private PublishedContainer publishedContainer;
    
    @Autowired
    private PublishInfoDAOUtils infoDAOUtils;
    
    @Override
    public List<PublishInformation> selectAllPublishInformation() {
        
        return publishedContainer.getContainer();
    }
    
    @Override
    public Map<String, List<String>> selectAllLikedInfo() {
        
        return likedContainer.getContainer();
    }
    
    @Override
    public Map<String, List<String>> selectAllPublishedInfo() {
        
        return publisherInfoContainer.getContainer();
    }
    
    @Override
    public void addNewPublishInformation(String publisherId, PublishInformation publishInformation) {
    
        /**
         * In two:
         * first, add the new information to container,
         * second, add the link to publisher(container and database)
         */
        try {
            publishedContainer.addMember(publishInformation);
            publisherInfoContainer.addMember(publisherId, publishInformation.getPublishInfoId());
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // TODO add the relation and object to database
        // INSERT_NEW_PUBLISH_INFORMATION, INSERT_NEW_PUBLISH_RELATION_PUBLISHER
    }
    
    @Override
    public void deletePublishInformation(String publisherId, PublishInformation publishInformation) {
    
        try {
            publishedContainer.removeMember(publishInformation);
            publisherInfoContainer.removeMember(publisherId, publishInformation.getPublishInfoId());
            likedContainer.removeValue(publishInformation.getPublishInfoId());
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        } catch (EmptyContainerException emptyContainerException) {
            emptyContainerException.printStackTrace();
        } catch (NullKeyException nullKeyException) {
            nullKeyException.printStackTrace();
        }
        // TODO remove the relation and object from database
        // DELETE_PUBLISH_INFORMATION, DELETE_PUBLISH_RELATION_PUBLISHER, DELETE_LIKED_PUBLISHED_BY_PUBLISH_ID
        
    }
    
    @Override
    public void modifyPublishInformation(PublishInformation publishInformation) {
    
        try {
            PublishInformation unModifyPublishInformation = publishedContainer.getSingleMember(publishInformation.getPublishInfoId());
            publishedContainer.removeMember(publishInformation);
            publishedContainer.addMember(publishInformation);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // TODO modify the object from database
        // MODIFY_PUBLISH_INFORMATION
    }
    
    @Override
    public void likedPublishedInformation(String userId, PublishInformation publishedInformation) {
    
        try {
            likedContainer.addMember(userId, publishedInformation.getPublishInfoId());
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // TODO add relation to database
        // INSERT_NEW_LIKED_PUBLISH_INFORMATION
    }
    
    @Override
    public void dislikePublishedInformation(String userId, PublishInformation publishedInformation) {
    
        try {
            likedContainer.removeMember(userId, publishedInformation.getPublishInfoId());
        } catch (NullKeyException nullKeyException) {
            nullKeyException.printStackTrace();
        } catch (EmptyContainerException emptyContainerException) {
            emptyContainerException.printStackTrace();
        }
        // TODO remove relation from database
        // DELETE_LIKED_PUBLISHED_INFORMATION
        
    }
}
