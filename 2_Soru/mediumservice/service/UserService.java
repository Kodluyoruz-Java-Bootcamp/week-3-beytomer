package com.medium.mediumservice.service;



import com.medium.mediumservice.model.User;
import com.medium.mediumservice.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserService() {
    }

    public void createUser(User user){
        userDao.createUser(user);
    }

    public List<User>getAllUser(){
        return userDao.findAllUsers();
    }

}
