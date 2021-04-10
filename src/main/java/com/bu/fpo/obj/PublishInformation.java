package com.bu.fpo.obj;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public class PublishInformation {
    
    private String publishInfoId;
    
    private String title;
    
    private String profile;

    private String requirement;

    private String location;

    private String salary;

    public String getPublishInfoId() {
        
        return publishInfoId;
    }
    
    public void setPublishInfoId(String publishInfoId) {
        
        this.publishInfoId = publishInfoId;
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
    
        return "PublishInformation{" +
                "publishInfoId='" + publishInfoId + '\'' +
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
            return info.getPublishInfoId() == this.publishInfoId &&
                    info.getTitle() == this.title &&
                    info.getProfile() == this.profile;
        }
        return false;
    }
}
