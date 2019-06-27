package com.company.models;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class Resource {

    String id;

    public Resource(){

    }

    public Resource(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return this.id;
    }

}
