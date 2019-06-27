package com.company.service.Impl;

import com.company.models.Role;
import com.company.models.User;
import com.company.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class UserServiceImpl implements UserService {

    public static Map<String, User> users;

    public UserServiceImpl(){
        users = new HashMap<>();
    }

    public void createUser(String id){
        User user = new User(id);
        addUser(user);
    }

    public User getUser(String id){
        return users.get(id);
    }

    public List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        users.forEach((key, value)->{
            allUsers.add(value);
        });
        return allUsers;
    }

    public void addRole(String id, Role role){
        users.get(id).addRoleToRolesMap(role);
    }

    public void removeRole(String id, String roleId){
        users.get(id).removeRoleFromRoleMap(roleId);
    }

    private void addUser(User user){
        users.put(user.getId(), user);
    }

}
