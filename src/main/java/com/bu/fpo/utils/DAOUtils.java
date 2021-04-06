package com.bu.fpo.utils;

import com.bu.fpo.constant.SQLConstant;
import com.bu.fpo.constant.UserType;
import com.bu.fpo.container.NormalUserContainer;
import com.bu.fpo.container.PublisherContainer;
import com.bu.fpo.container.interfase.MapListContainer;
import com.bu.fpo.exception.SameValueException;
import com.bu.fpo.obj.LinkedData;
import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.obj.interfase.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This class created on 4/5/2021
 *
 * @author Elon.Zhang
 */

@Component
public class DAOUtils {
    
    public static void splitUser2Container(NormalUserContainer userContainer, PublisherContainer publisherContainer, List<User> users) {
        
        for (User user : users) {
            int userType = user.getUserType();
            try {
                switch (userType) {
                    
                    case 0:
                        userContainer.addMember((NormalUser) user);
                        break;
                    case 1:
                        publisherContainer.addMember((Publisher) user);
                        break;
                }
            } catch (SameValueException e) {
                // skip the value
                continue;
            }
        }
        
    }
    
    
    public static void splitInfo2Container(List<LinkedData> linkedDatas, MapListContainer container) {
        
        for (LinkedData data : linkedDatas) {
            try {
                container.addMember(data.getUserId(), data.getPublishId());
            } catch (SameValueException e) {
                continue;
            }
        }
        
    }
}
