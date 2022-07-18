package com.enterprise.coffee.Restful.API.service;

import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.model.Manager;

import java.util.List;

public interface CommunityService {

    List<Community> getAllCommunity();

    Community createCommunity(Community community);

}
