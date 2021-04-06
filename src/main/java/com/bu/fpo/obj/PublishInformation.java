package com.bu.fpo.obj;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public class PublishInformation {
    
    private String publishInfoId;
    
    private String publisherId;
    
    private String title;
    
    private String profile;
    
    public String getPublishInfoId() {
        
        return publishInfoId;
    }
    
    public void setPublishInfoId(String publishInfoId) {
        
        this.publishInfoId = publishInfoId;
    }
    
    public String getPublisherId() {
        
        return publisherId;
    }
    
    public void setPublisherId(String publisherId) {
        
        this.publisherId = publisherId;
    }
    
    public String getTitle() {
        
        return title;
    }
    
    public void setTitle(String title) {
        
        this.title = title;
    }
    
    public String getProfile() {
        
        return profile;
    }
    
    public void setProfile(String profile) {
        
        this.profile = profile;
    }
    
    @Override
    public String toString() {
    
        return "PublishInformation{" +
                "publishInfoId='" + publishInfoId + '\'' +
                ", publisherId='" + publisherId + '\'' +
                ", title='" + title + '\'' +
                ", profile=" + profile + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        
        PublishInformation info = null;
        if (obj instanceof PublishInformation) {
            info = (PublishInformation) obj;
        }
        if (info != null) {
            return info.getPublisherId() == this.publisherId &&
                    info.getPublishInfoId() == this.publishInfoId &&
                    info.getTitle() == this.title &&
                    info.getProfile() == this.profile;
        }
        return false;
    }
}