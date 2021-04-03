package com.bu.fpo.dao.interfase;

import com.bu.fpo.obj.PublishInformation;

import java.util.List;

/**
 * This class created on 4/2/2021
 *
 * @author Elon.Zhang
 */
public interface PublishInfoDAO {
    
    List<PublishInformation> selectAllPublishInformation();
    
    void addNewPublishInformation(PublishInformation publishInformation);
    
    void deletePublishInformation(PublishInformation publishInformation);
    
    void modifyPublishInformation(PublishInformation publishInformation);

}
