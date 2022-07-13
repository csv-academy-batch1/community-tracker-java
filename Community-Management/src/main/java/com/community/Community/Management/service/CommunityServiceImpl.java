package com.community.Community.Management.service;

import com.community.Community.Management.model.Community;
import com.community.Community.Management.model.CommunityDTO;
import com.community.Community.Management.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public Community createNewCommunity(CommunityDTO communityDTO){
            Community community = new Community();
            community.setCommunityName(communityDTO.getCommunityName());
            community.setCommunityManagerId(communityDTO.getCommunityManagerId());
            community.setCommunityDesc(communityDTO.getCommunityDesc());
            return communityRepository.save(community);
    }
    @Override
    public Community findCommunityByName(String name) {
        return communityRepository.findByCommunityName(name);
    }
}
