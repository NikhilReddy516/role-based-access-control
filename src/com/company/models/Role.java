package com.company.models;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class Role {

    String id;
    HashMap<String, List<ActionType>> resourceActionMap;


    public Role(){

    }

    public Role(String id){
        this.id = id;
        this.resourceActionMap = new HashMap<>();
    }

    public Role(String id, HashMap<String, List<ActionType>> resourceActionMap){
        this.id = id;
        this.resourceActionMap = resourceActionMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, List<ActionType>> getResourceActionMap() {
        return resourceActionMap;
    }

    public void setResourceActionMap(HashMap<String, List<ActionType>> resourceActionMap) {
        this.resourceActionMap = resourceActionMap;
    }

    public String toString(){
        StringBuilder value = new StringBuilder();
        value.append("{ id: "+this.id+ ", ");
        value.append("resourceActionMap: { ");
        this.resourceActionMap.forEach((k,v) -> {
            value.append(k+ ", [");
            v.forEach(actionType -> {
                value.append(actionType.getAction() + ", ");
            });
            value.append(" ], ");
        });
        value.append(" } }");

        return value.toString();
    }

}
