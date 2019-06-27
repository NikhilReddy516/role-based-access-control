package com.company.service;

import com.company.models.Resource;

import java.util.List;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public interface ResourceService {

    public void createResource(String resourceName);

    public List<Resource> getAllResources();

    public Resource getResource(String id);


}
