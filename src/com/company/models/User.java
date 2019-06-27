package com.company.models;


import java.util.HashMap;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class User {


    private String id;
    private HashMap<String, Role> rolesMap;

    public User(){
    }

    public User(String id){
        this.id = id;
        this.rolesMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Role> getRolesMap() {
        return rolesMap;
    }

    public void setRolesMap(HashMap<String, Role> rolesMap) {
        this.rolesMap = rolesMap;
    }

    public void addRoleToRolesMap(Role role){
        this.rolesMap.put(role.getId(), role);
    }

    public void removeRoleFromRoleMap(String roleId){
        this.rolesMap.remove(roleId);
    }

    public String toString(){
        StringBuilder value = new StringBuilder();
        value.append("{ id: "+this.id+", rolesMap: {");
        this.rolesMap.forEach((k, v) -> {
            value.append(k+", ");
            value.append(v.toString() + ", ");
        });
        value.append("} }");
        return value.toString();
    }

}
