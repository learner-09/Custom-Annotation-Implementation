package com.anand.service;

import com.anand.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private Service service;

    @Test
    public void testGetUserById(){
        User user=new User(1,"Abhishek","Anand");
        System.out.println(service.getUserById(2).getFirstName());
        User user1=service.getUserById(1);
        assertNotSame(user,user1);
        assertTrue(user.equals(user1));
    }
}
