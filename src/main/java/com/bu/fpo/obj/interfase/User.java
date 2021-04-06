package com.bu.fpo.obj.interfase;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public abstract class User {
    
    private String userId;
    
    private String username;
    
    private String password;
    
    private int userType;
    
    private String phone;
    
    private String profile;
    
    public User(String userId, String username, String password, int userType, String phone, String profile) {
        
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.phone = phone;
        this.profile = profile;
    }
    
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
    
    @Override
    public String toString() {
        
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", phone='" + phone + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
    
}