package com.community.Community.Management.service;

import com.community.Community.Management.model.Community;
import com.community.Community.Management.model.CommunityManager;
import com.community.Community.Management.repository.CommunityManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityManagerServiceImpl implements CommunityManagerService{

    @Autowired
    private CommunityManagerRepository communityManagerRepository;

    @Override
    public CommunityManager getCommunityManagerByID(int id) {
        Optional<CommunityManager> communityManager = communityManagerRepository.findById(id);
        return communityManager.orElse(null);
    }

}
