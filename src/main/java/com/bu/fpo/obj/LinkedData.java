package com.bu.fpo.obj;
public  class LinkedData {

    private String userId;

    private String username;

    private String password;

    private String PublishId;

    private String title;

    private String profile;

    public LinkedData() {
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }


    public String getUserId() {

        return userId;
    }





    public void setPublishId(String setPublishId) {

        this.PublishId = setPublishId;
    }

    public String getPublishId() {

        return PublishId;
    }



    public String getProfile() {

        return profile;
    }

    public void setProfile(String profile) {

        this.profile = profile;
    }
}