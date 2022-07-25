package com.enterprise.coffee.Restful.API.service;

import com.enterprise.coffee.Restful.API.model.Community;

import java.util.List;

public interface CommunityService {
    List<Community> getAllCommunity();

    Community createCommunity(Community community);

    Community updateCommunity(Community community, Long id);

    void deleteCommunity(Long id);

}
