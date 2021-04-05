package com.bu.fpo.service;

import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.service.Interfase.PublishInformationService;

import java.util.List;

/**
 * This class created on 4/4/2021
 *
 * @author Elon.Zhang
 */
public class PublishInformationServiceImp implements PublishInformationService {
    
    @Override
    public List<PublishInformation> findAllPublishInformation() {
        
        return null;
    }
    
    @Override
    public List<PublishInformation> findLikedPublishInfo(String userId) {
        
        return null;
    }
    
    @Override
    public List<PublishInformation> findPublishedInformation(String publisherId) {
        
        return null;
    }
    
    @Override
    public boolean cancelLikedPublishInfo(String userId, String publishInfoId) {
        
        return false;
    }
    
    @Override
    public boolean cancelPublishedInfo(String publisherId, String publishInfoId) {
        
        return false;
    }
    
    @Override
    public boolean likePublishInfo(String userId, String publishInfoId) {
        
        return false;
    }
    
    @Override
    public boolean publishInfo(String publisherId, PublishInformation publishInformation) {
        
        return false;
    }
    
    @Override
    public boolean modifyPublishInfomation(String publisherId, PublishInformation publishInformation) {
        
        return false;
    }
}
