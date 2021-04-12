package com.bu.fpo.constant;

/**
 * This class created on 4/5/2021
 *
 * @author Elon.Zhang
 */
public class SQLConstant {
    
    /*
        USER SQL
     */
    
    public static String QUERY_ALL_USER = "select * from user";
    
    public static String INSERT_NEW_USER = "insert into user(user_id, user_name, password, user_type, phone, profile) values(?,?,?,?,?,?) ";
    
    public static String DELETE_USER = "delete from user where user_id = ?";
    
    public static String MODIFY_USER = "update user set password=?, phone=?, profile=? where user_id=?";
    
    /*
        PUBLISH INFORMATION SQL
     */
    
    public static String QUERY_ALL_PUBLISHED_INFORMATION = "select * from publish_information";
    
    public static String INSERT_NEW_PUBLISH_INFORMATION = "insert into publish_information(publish_id, title, profile,location,salary,requirement) values(?,?,?,?,?,?)";
    
    public static String DELETE_PUBLISH_INFORMATION = "delete from publish_information where publish_id=?";
    
    public static String MODIFY_PUBLISH_INFORMATION = "update publish_information set title=?,profile=?,location=?,salary=?,requirement=? where publish_id=?";
    
    /*
        LIKED PUBLISH SQL
     */
    
    public static String QUERY_LIKED_PUBLISHED_INFORMATION = "select * from liked_info";
    
    public static String DELETE_LIKED_PUBLISHED_BY_PUBLISH_ID = "delete from liked_info where publish_id=?";
    
    public static String INSERT_NEW_LIKED_PUBLISH_INFORMATION = "insert into liked_info(user_id, publish_id) values(?,?)";
    
    public static String DELETE_LIKED_PUBLISHED_INFORMATION = "delete from liked_info where user_id=? AND publish_id=?";
    
    /*
        PUBLISHER PUBLISHED SQL
     */
    
    public static String QUERY_PUBLISER_PUBLISHED_INFORMATION = "select *from publisher_info";
    
    public static String INSERT_NEW_PUBLISH_RELATION_PUBLISHER = "insert into publisher_info(user_id, publish_id) values(?,?)";
    
    public static String DELETE_PUBLISH_RELATION_PUBLISHER = "delete from publisher_info where user_id=? AND publish_id=?";
    
}
