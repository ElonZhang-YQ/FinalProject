package com.bu.fpo.service;

import com.bu.fpo.constant.SQLConstant;
import com.bu.fpo.constant.UserType;
import com.bu.fpo.container.LikedContainer;
import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.container.PublishedContainer;
import com.bu.fpo.container.PublisherInfomationContainer;
import com.bu.fpo.container.PublisherContainer;
import com.bu.fpo.container.interfase.MapListContainer;
import com.bu.fpo.obj.LinkedData;
import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.PublishInformation;
import com.bu.fpo.obj.interfase.User;
import com.bu.fpo.utils.DAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class created on 4/6/2021
 *
 * @author Elon.Zhang
 */

@Component
public class DataInstanceService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private NormalUserContainer userContainer;
    
    @Autowired
    private PublisherContainer publisherContainer;
    
    @Autowired
    private PublishedContainer publishedContainer;
    
    @Autowired
    private LikedContainer likedContainer;
    
    @Autowired
    private PublisherInfomationContainer infoContainer;
    
    private DataInstanceService() {
        // TODO when database finished, cancel the annotation
//        instanceUserData();
//        instancePublishedData();
//        instanceLinkedData(SQLConstant.QUERY_LIKED_PUBLISHED_INFORMATION, likedContainer);
//        instanceLinkedData(SQLConstant.QUERY_PUBLISER_PUBLISHED_INFORMATION, infoContainer);
    }
    
    private void instanceUserData() {
        List<User> users = jdbcTemplate.query(SQLConstant.QUERY_ALL_USER, new RowMapper<User>(){
        
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            
                User user = null;
                int userType = rs.getInt("user_type");
                switch (userType) {
                    case 0:
                        // NORMAL_USER
                        user = new NormalUser();
                        user.setUserType(UserType.NORMAL_USER);
                        break;
                    case 1:
                        // PUBLISHER
                        user = new NormalUser();
                        user.setUserType(UserType.PUBLISHER);
                        break;
                
                }
                user.setUserId("user_id");
                user.setUsername("user_name");
                user.setPassword("password");
                user.setPhone("phone");
                user.setProfile("profile");
                return user;
            }
        });
        DAOUtils.splitUser2Container(userContainer, publisherContainer, users);
    }
    
    private void instancePublishedData() {
    
        List<PublishInformation> infos = jdbcTemplate.query(SQLConstant.QUERY_ALL_PUBLISHED_INFORMATION, new RowMapper<PublishInformation>(){
        
            @Override
            public PublishInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
    
                PublishInformation publishedInformation = new PublishInformation();
                publishedInformation.setPublishInfoId("publish_id");
                publishedInformation.setTitle("title");
                publishedInformation.setProfile("profile");
                return publishedInformation;
            }
        });
        publishedContainer.addMembers(infos);
    }
    
    private void instanceLinkedData(String sql, MapListContainer container) {
    
        List<LinkedData> linkedDatas = jdbcTemplate.query(sql, new RowMapper<LinkedData>(){
        
            @Override
            public LinkedData mapRow(ResultSet rs, int rowNum) throws SQLException {
    
                LinkedData data = new LinkedData();
                data.setUserId("user_id");
                data.setPublishId("publish_id");
                return data;
            }
        });
        DAOUtils.splitInfo2Container(linkedDatas, container);
    }
    
}
