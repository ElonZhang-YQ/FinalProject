package com.bu.fpo.servceiTest;

import com.bu.fpo.obj.NormalUser;
import com.bu.fpo.obj.Publisher;
import com.bu.fpo.obj.interfase.User;
import org.junit.jupiter.api.Test;

/**
 * This class created on 4/6/2021
 *
 * @author Elon.Zhang
 */


public class DemoTest {
    
    @Test
    public void testObjectType() {
    
        NormalUser user = new NormalUser();
        
        Publisher publisher = new Publisher();
        
        System.out.println(user instanceof User);
        
    
    }
    
}
