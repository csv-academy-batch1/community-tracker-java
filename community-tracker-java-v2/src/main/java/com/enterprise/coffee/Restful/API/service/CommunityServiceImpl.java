package com.enterprise.coffee.Restful.API.service;

import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import com.enterprise.coffee.Restful.API.validator.AddValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private AddValidator addValidator;

    @Override
    public List<Community> getAllCommunity() {
        return communityRepository.getCommunityByStatus(true);
    }

    @Override
    public Community createCommunity(Community community) {
            addValidator.validateCommunityName(community);
            return communityRepository.save(community);
    }


}
