package com.company.models;


/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public enum  ActionType {

    READ("read", "read-only"),
    WRITE("write", "write"),
    DELETE("delete", "remove");

    String action;
    String description;

    ActionType(String action, String description){
        this.action = action;
        this.description = description;
    }

    public String getAction(){
        return this.action;
    }

    public void setAction(String action){
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ActionType getActionType(String action){

        for(ActionType actionType : ActionType.values()){
            if(actionType.action.equals(action)){
                return actionType;
            }
        }

        return null;
    }


}
