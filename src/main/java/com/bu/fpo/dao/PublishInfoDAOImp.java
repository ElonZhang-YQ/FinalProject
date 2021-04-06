package com.bu.fpo.dao;

import com.bu.fpo.constant.SQLConstant;
import com.bu.fpo.container.LikedContainer;
import com.bu.fpo.container.PublishedContainer;
import com.bu.fpo.container.PublisherInformationContainer;
import com.bu.fpo.dao.interfase.PublishInfoDAO;
import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
import com.bu.fpo.exception.values.EmptyContainerException;
import com.bu.fpo.exception.values.NullKeyException;
import com.bu.fpo.exception.values.NullValueException;
import com.bu.fpo.exception.values.SameValueException;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.utils.dao.PublishInfoDAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private LikedContainer likedContainer;
    
    @Autowired
    private PublisherInformationContainer publisherInfoContainer;
    
    @Autowired
    private PublishedContainer publishedContainer;
    
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
    public void addNewPublishInformation(String publisherId, PublishInformation publishInformation) throws DataBaseInsertException {
    
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
        // INSERT_NEW_PUBLISH_INFORMATION, INSERT_NEW_PUBLISH_RELATION_PUBLISHER
        int addInfoResult = jdbcTemplate.update(SQLConstant.INSERT_NEW_PUBLISH_INFORMATION, publishInformation.getPublishInfoId(), publishInformation.getTitle(), publishInformation.getProfile());
        int addRelationResult = jdbcTemplate.update(SQLConstant.INSERT_NEW_PUBLISH_RELATION_PUBLISHER, publisherId, publishInformation.getPublishInfoId());
        if (addInfoResult == 0 || addRelationResult == 0) {
            throw new DataBaseInsertException();
        }
    }
    
    @Override
    public void deletePublishInformation(String publisherId, PublishInformation publishInformation) throws DatabaseDeleteException {
    
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
        // DELETE_PUBLISH_INFORMATION, DELETE_PUBLISH_RELATION_PUBLISHER, DELETE_LIKED_PUBLISHED_BY_PUBLISH_ID
        int deleteInfoResult = jdbcTemplate.update(SQLConstant.DELETE_PUBLISH_INFORMATION, publishInformation.getPublishInfoId());
        int deletePublisherRelationResult = jdbcTemplate.update(SQLConstant.DELETE_PUBLISH_RELATION_PUBLISHER, publisherId, publishInformation.getPublishInfoId());
        int deleteLikedRelationResult = jdbcTemplate.update(SQLConstant.DELETE_LIKED_PUBLISHED_BY_PUBLISH_ID, publishInformation.getPublishInfoId());
        if (deleteInfoResult == 0 || deletePublisherRelationResult == 0 || deleteLikedRelationResult == 0) {
            throw new DatabaseDeleteException();
        }
    }
    
    @Override
    public void modifyPublishInformation(PublishInformation publishInformation) throws DatabaseModifyException {
    
        try {
            PublishInformation unModifyPublishInformation = publishedContainer.getSingleMember(publishInformation.getPublishInfoId());
            publishedContainer.removeMember(publishInformation);
            publishedContainer.addMember(publishInformation);
        } catch (NullValueException nullValueException) {
            nullValueException.printStackTrace();
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // MODIFY_PUBLISH_INFORMATION
        int modifyResult = jdbcTemplate.update(SQLConstant.MODIFY_PUBLISH_INFORMATION, publishInformation.getTitle(), publishInformation.getProfile(), publishInformation.getPublishInfoId());
        if (modifyResult == 0) {
            throw new DatabaseModifyException();
        }
    }
    
    @Override
    public void likedPublishedInformation(String userId, PublishInformation publishedInformation) throws DataBaseInsertException {
    
        try {
            likedContainer.addMember(userId, publishedInformation.getPublishInfoId());
        } catch (SameValueException sameValueException) {
            sameValueException.printStackTrace();
        }
        // INSERT_NEW_LIKED_PUBLISH_INFORMATION
        int addResult = jdbcTemplate.update(SQLConstant.INSERT_NEW_LIKED_PUBLISH_INFORMATION, userId, publishedInformation.getPublishInfoId());
        if (addResult == 0) {
            throw new DataBaseInsertException();
        }
    }
    
    @Override
    public void dislikePublishedInformation(String userId, PublishInformation publishedInformation) throws DatabaseDeleteException {
    
        try {
            likedContainer.removeMember(userId, publishedInformation.getPublishInfoId());
        } catch (NullKeyException nullKeyException) {
            nullKeyException.printStackTrace();
        } catch (EmptyContainerException emptyContainerException) {
            emptyContainerException.printStackTrace();
        }
        // TODO remove relation from database
        // DELETE_LIKED_PUBLISHED_INFORMATION
        int deleteResult = jdbcTemplate.update(SQLConstant.DELETE_LIKED_PUBLISHED_INFORMATION, userId, publishedInformation.getPublishInfoId());
        if (deleteResult == 0) {
            throw new DatabaseDeleteException();
        }
    }
}
