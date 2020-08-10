package com.anand.service;

import com.anand.datasource.DataSource;
import com.anand.decryption.DecryptionUtil;
import com.anand.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class Service {

    private static Logger logger= LoggerFactory.getLogger(Service.class);

    @Autowired
    private DecryptionUtil decryptionUtil;

    @Autowired
    private DataSource dataSource;

    public User getUserById(int id){
        for (User user:dataSource.returnUsers()){
            if (user.getId()==id){
                user= (User) decryptionUtil.decryptString(user);
                logger.info("New User",user);
                return user;
            }
        }
        return null;
    }

}
