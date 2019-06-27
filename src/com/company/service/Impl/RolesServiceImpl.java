package com.company.service.Impl;

import com.company.models.ActionType;
import com.company.models.Role;
import com.company.service.RolesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class RolesServiceImpl implements RolesService {

    public static Map<String, Role> roles;

    public RolesServiceImpl(){
        roles = new HashMap<>();
    }

    public void createRole(String id, HashMap<String, List<ActionType>> resouceActionMap){
        Role role = new Role(id, resouceActionMap);
        addRole(role);
    }

    public Role getRole(String id){
        return roles.get(id);
    }

    private void addRole(Role role){
        roles.put(role.getId(), role);
    }

    public List<Role> getAllRoles(){
        List<Role> allRoles = new ArrayList<>();
        roles.forEach((key, value)->{
            allRoles.add(value);
        });

        return allRoles;
    }
}
