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
        communityValidator.validateCommunityId(community);               //Validate Community ID if exist
        communityValidator.validateCommunityIdForUpdate(community, id);  //Validate Community ID and  Endpoint if match
        communityValidator.validateCommunityIsActive(id);                //Validate Community if Active
        communityValidator.validateCommunityManager(community);          //Validate Community Manager if exist
        communityValidator.validateUpdateCommunityName(community, id);   //Validate Community name if match to the community id and community name if exist

        Community existingCommunity = communityRepository.findById(id).get();
        existingCommunity.setCommunityId(id);
        existingCommunity.setCommunityName(community.getCommunityName());
        existingCommunity.setCommunityMgrid(community.getCommunityMgrid());
        existingCommunity.setCommunityDesc(community.getCommunityDesc());
        return communityRepository.save(existingCommunity);
    }

    @Override
    public void deleteCommunity(Long id) {
        communityValidator.validateCommunityIdForDeletion(id);
        communityValidator.validateCommunityIsActive(id);

        Community community = communityRepository.findById(id).get();
        community.setIsActive(false);
        communityRepository.save(community);
    }
}
