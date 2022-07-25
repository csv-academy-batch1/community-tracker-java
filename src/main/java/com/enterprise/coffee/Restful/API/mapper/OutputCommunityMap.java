package com.enterprise.coffee.Restful.API.mapper;

import com.enterprise.coffee.Restful.API.model.*;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OutputCommunityMap {

    @Autowired
    private CommunityRepository communityRepository;

    public CreateCommunityResponse addedCommunityMap(Community community, Manager manager){
        CreateCommunityResponse createCommunityResponse = new CreateCommunityResponse();
        createCommunityResponse.setCommunityId(community.getCommunityId());
        createCommunityResponse.setCommunityName(community.getCommunityName());
        createCommunityResponse.setCommunityManagerName(manager.getCommunityMgrName());
        createCommunityResponse.setCommunityDesc(community.getCommunityDesc());
        createCommunityResponse.setIsActive(community.getIsActive());
        return createCommunityResponse;
    }
    public GetCommunityResponse activeCommunityMap(List<Community> communityObj){
        List<CommunityList> list = new ArrayList<>();
        for (Community community : communityObj) {
            CommunityList communityList = new CommunityList();
            communityList.setCommunityId(community.getCommunityId());
            communityList.setCommunityName(community.getCommunityName());
            communityList.setCommunityMgrId(community.getCommunityMgrid());
            communityList.setDescription(community.getCommunityDesc());
            list.add(communityList);
        }
        GetCommunityResponse communityGetResponse = new GetCommunityResponse();
        communityGetResponse.setCommunities(list);
        return communityGetResponse;
    }
    public CreateCommunityResponse updatedCommunityMap(Community community, Manager manager, Long id){
        CreateCommunityResponse updateCommunityResponse = new CreateCommunityResponse();
        updateCommunityResponse.setCommunityId(id);
        updateCommunityResponse.setCommunityName(community.getCommunityName());
        updateCommunityResponse.setCommunityManagerName(manager.getCommunityMgrName());
        updateCommunityResponse.setCommunityDesc(community.getCommunityDesc());
        updateCommunityResponse.setIsActive(community.getIsActive());
        return updateCommunityResponse;
    }
}
