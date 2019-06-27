package com.company.service;

import com.company.models.Role;
import com.company.models.User;

import java.util.List;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public interface UserService {

    public void createUser(String id);

    public User getUser(String id);

    public List<User> getAllUsers();

    public void addRole(String id, Role role);

    public void removeRole(String id, String roleId);

}
