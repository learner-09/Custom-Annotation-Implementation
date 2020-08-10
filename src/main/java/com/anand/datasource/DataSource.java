package com.anand.datasource;

import com.anand.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSource {
    public List<User> returnUsers(){
        return Arrays.asList(new User(1,"Abhishek","Anand"),new User(2,"Abhi","Kumar"));
    }
}
