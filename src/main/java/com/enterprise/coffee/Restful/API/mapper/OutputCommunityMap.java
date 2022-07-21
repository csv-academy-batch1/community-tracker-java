package com.enterprise.coffee.Restful.API.mapper;

import com.enterprise.coffee.Restful.API.model.*;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import com.enterprise.coffee.Restful.API.response.CommunityList;
import com.enterprise.coffee.Restful.API.response.CreateCommunityResponse;
import com.enterprise.coffee.Restful.API.response.GetCommunityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OutputCommunityMap {

    @Autowired
    private CommunityRepository communityRepository;

    public CreateCommunityResponse addedCommunityMap( Community community, Manager manager){
        CreateCommunityResponse createCommunityResponse = new CreateCommunityResponse();
        createCommunityResponse.setCommunityId(community.getCommunityId());
        createCommunityResponse.setCommunityName(community.getCommunityName());
        createCommunityResponse.setCommunityManager(manager.getCommunityMgrName());
        createCommunityResponse.setCommunityDesc(community.getDescription());
        createCommunityResponse.setIsActive(community.getIsActive());
        return createCommunityResponse;
    }
    public GetCommunityResponse activeCommunityMap(List<Community> communityObj){
        List<CommunityList> list = new ArrayList<>();
        for (Community community : communityObj) {
            CommunityList communityList = new CommunityList();
            communityList.setCommunityId(community.getCommunityId());
            communityList.setCommunityName(community.getCommunityName());
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
        updateCommunityResponse.setCommunityManager(manager.getCommunityMgrName());
        updateCommunityResponse.setCommunityDesc(community.getDescription());
        updateCommunityResponse.setIsActive(community.getIsActive());
        return updateCommunityResponse;
    }
}
