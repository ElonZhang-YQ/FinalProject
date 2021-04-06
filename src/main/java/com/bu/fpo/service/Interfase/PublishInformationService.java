package com.bu.fpo.service.Interfase;

import com.bu.fpo.obj.PublishInformation;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface PublishInformationService {

    List<PublishInformation> findAllPublishInformation();
    
    List<PublishInformation> findLikedOrPublishedPublishInfo(String userId, int userType);
    
    boolean cancelLikedPublishInfo(String userId, String publishInfoId);
    
    boolean cancelPublishedInfo(String publisherId, String publishInfoId);
    
    boolean likePublishInfo(String userId, String publishInfoId);
    
    boolean publishInfo(String publisherId, PublishInformation publishInformation);
    
    boolean modifyPublishInfomation(String publisherId, PublishInformation publishInformation);

}
