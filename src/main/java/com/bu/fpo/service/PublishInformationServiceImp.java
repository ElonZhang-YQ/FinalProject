package com.bu.fpo.service;

import com.bu.fpo.constant.UserType;
import com.bu.fpo.dao.interfase.PublishInfoDAO;
import com.bu.fpo.exception.database.DataBaseInsertException;
import com.bu.fpo.exception.database.DatabaseDeleteException;
import com.bu.fpo.exception.database.DatabaseModifyException;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.service.Interfase.PublishInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class created on 4/4/2021
 *
 * @author Elon.Zhang
 */

@Service
public class PublishInformationServiceImp implements PublishInformationService {
    
    @Autowired
    private PublishInfoDAO publishInfoDAO;
    
    @Override
    public List<PublishInformation> findAllPublishInformation() {
        
        return publishInfoDAO.selectAllPublishInformation();
    }
    
    /**
     * NormalUser type = UserType.NORMAL_USER
     * Publisher type = UserType.PUBLISHER
     * <p>
     * if user type = NormalUser Type, this function find current users liked publish information
     * if user type = Publisher Type, this function find current publishers publish information
     *
     * @param userId
     * @param userType
     * @return
     */
    @Override
    public List<PublishInformation> findLikedOrPublishedPublishInfo(String userId, int userType) {
        
        List<PublishInformation> result = new ArrayList<PublishInformation>();
        Map<String, List<String>> infos = null;
        
        switch (userType) {
            case 0:
                infos = publishInfoDAO.selectAllLikedInfo();
                break;
            case 1:
                infos = publishInfoDAO.selectAllPublishedInfo();
                break;
        }
        
        List<String> publisheIds = infos.get(userId);
        List<PublishInformation> publishInformations = publishInfoDAO.selectAllPublishInformation();
        for (String publishId : publisheIds) {
            for (PublishInformation info : publishInformations) {
                if (info.getPublishInfoId().equals(publishId)) {
                    result.add(info);
                }
            }
        }
        return result;
    }
    
    /**
     * find all publish informations
     * if use this function, must take null value checks
     *
     * @param publishInfoId
     * @return
     */
    @Override
    public PublishInformation findPublishInformationById(String publishInfoId) {
        
        List<PublishInformation> publishInformations = publishInfoDAO.selectAllPublishInformation();
        for (PublishInformation publishInformation : publishInformations) {
            if (publishInformation.getPublishInfoId().equals(publishInfoId)) {
                return publishInformation;
            }
        }
        return null;
    }
    
    @Override
    public List<PublishInformation> searchPublishInformationByKey(String... keys) {
    
        List<PublishInformation> results = new ArrayList<PublishInformation>();
        List<PublishInformation> allPublishInformations = findAllPublishInformation();
        for (PublishInformation publishInformation : allPublishInformations) {
            for (String key : keys) {
                if (publishInformation.getTitle().contains(key)) {
                    results.add(publishInformation);
                }
            }
        }
        return results;
    }
    
    @Override
    public boolean cancelLikedPublishInfo(String userId, String publishInfoId) {
        
        PublishInformation publishInformation = findSinglePublishInformation(publishInfoId);
        if (publishInformation != null) {
            try {
                publishInfoDAO.dislikePublishedInformation(userId, publishInformation);
                return true;
            } catch (DatabaseDeleteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public boolean cancelPublishedInfo(String publisherId, String publishInfoId) {
        
        PublishInformation publishInformation = findSinglePublishInformation(publishInfoId);
        if (publishInformation != null) {
            try {
                publishInfoDAO.deletePublishInformation(publisherId, publishInformation);
                return true;
            } catch (DatabaseDeleteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public boolean likePublishInfo(String userId, String publishInfoId) {
        
        PublishInformation publishInformation = findSinglePublishInformation(publishInfoId);
        if (publishInformation != null) {
            try {
                publishInfoDAO.likedPublishedInformation(userId, publishInformation);
                return true;
            } catch (DataBaseInsertException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public boolean publishInfo(String publisherId, PublishInformation publishInformation) {
        
        try {
            publishInfoDAO.addNewPublishInformation(publisherId, publishInformation);
        } catch (DataBaseInsertException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    @Override
    public boolean modifyPublishInfomation(String publisherId, PublishInformation publishInformation) {
        
        if (isPublisher(publisherId, publishInformation.getPublishInfoId())) {
            try {
                publishInfoDAO.modifyPublishInformation(publishInformation);
                return true;
            } catch (DatabaseModifyException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    private PublishInformation findSinglePublishInformation(String publishInfoId) {
        
        List<PublishInformation> publishInformations = publishInfoDAO.selectAllPublishInformation();
        for (PublishInformation publishInformation : publishInformations) {
            if (publishInformation.getPublishInfoId().equals(publishInfoId)) {
                return publishInformation;
            }
        }
        return null;
    }
    
    /**
     * check is the publish information belongs to current publisher
     *
     * @param publisherId
     * @param publishInfoId
     * @return
     */
    private boolean isPublisher(String publisherId, String publishInfoId) {
        
        List<PublishInformation> publishedInformations = findLikedOrPublishedPublishInfo(publisherId, UserType.PUBLISHER);
        for (PublishInformation publishedInformation : publishedInformations) {
            if (publishedInformation.getPublishInfoId().equals(publishInfoId)) {
                return true;
            }
        }
        return false;
    }
    
    
}
