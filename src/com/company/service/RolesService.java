package com.company.service;

import com.company.models.ActionType;
import com.company.models.Role;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public interface RolesService {

    public void createRole(String id, HashMap<String, List<ActionType>> resouceActionMap);

    public Role getRole(String id);

    public List<Role> getAllRoles();
}
