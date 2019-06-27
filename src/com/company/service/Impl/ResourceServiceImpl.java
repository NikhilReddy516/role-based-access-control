package com.company.service.Impl;

import com.company.models.Resource;
import com.company.service.ResourceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class ResourceServiceImpl implements ResourceService {

    public static Map<String, Resource> resources;


    public ResourceServiceImpl(){
        resources = new HashMap<>();
    }

    public void createResource(String resourceName){
        Resource resource = new Resource(resourceName);
        addResource(resource);
    }

    public Resource getResource(String resourceName){
        return resources.get(resourceName);
    }

    public List<Resource> getAllResources(){
        List<Resource> allResources = new ArrayList<>();
        resources.forEach((key, value)->{
            allResources.add(value);
        });
        return allResources;
    }

    private void addResource(Resource resource){
        resources.put(resource.getId(), resource);
    }

}
