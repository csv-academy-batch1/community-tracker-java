package com.enterprise.coffee.Restful.API.service;

import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import com.enterprise.coffee.Restful.API.validator.CommunityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private CommunityValidator communityValidator;

    @Override
    public List<Community> getAllCommunity() {
        return communityRepository.getCommunityByIsActive(true);
    }

    @Override
    public Community createCommunity(Community community) {
        communityValidator.validateCommunityName(community);
        communityValidator.validateCommunityManager(community);
        community.setIsActive(true);
        return communityRepository.save(community);
    }

    @Override
    public Community updateCommunity(Community community, Long id) {

        communityValidator.validateCommunityIdForUpdate(community, id);
        communityValidator.validateCommunityId(community);
        communityValidator.validateCommunityIsActive(id);
        communityValidator.validateCommunityManager(community);
        communityValidator.validateUpdateCommunityName(community, id);

        Community existingCommunity = communityRepository.findById(id).get();
        existingCommunity.setCommunityId(id);
        existingCommunity.setCommunityName(community.getCommunityName());
        existingCommunity.setCommunityMgrid(community.getCommunityMgrid());
        existingCommunity.setCommunityDesc(community.getCommunityDesc());
        return communityRepository.save(existingCommunity);
    }
}
