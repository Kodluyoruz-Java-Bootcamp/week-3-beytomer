package com.medium.mediumservice.repository;



import com.medium.mediumservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDao {

    private static List<User>userList=new ArrayList<>();

    public void createUser(User user){
        userList.add(user);
    }

    public List<User> findAllUsers(){
        return userList;
    }

}
