package com.bu.fpo.obj.interfase;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public abstract class User {
    
    public String userId;
    
    public String username;
    
    public String password;
    
    public int userType;
    
    public String phone;
    
    public String profile;
    
    public String getUserId() {
        
        return userId;
    }
    
    public void setUserId(String userId) {
        
        this.userId = userId;
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public String getPassword() {
        
        return password;
    }
    
    public void setPassword(String password) {
        
        this.password = password;
    }
    
    public int getUserType() {
        
        return userType;
    }
    
    public void setUserType(int userType) {
        
        this.userType = userType;
    }
    
    public String getPhone() {
        
        return phone;
    }
    
    public void setPhone(String phone) {
        
        this.phone = phone;
    }
    
    public String getProfile() {
        
        return profile;
    }
    
    public void setProfile(String profile) {
        
        this.profile = profile;
    }
}