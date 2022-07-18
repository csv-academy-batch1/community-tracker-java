package com.enterprise.coffee.Restful.API.mapper;

import com.enterprise.coffee.Restful.API.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OutputCommunityMap {
    public CreateCommunityResponse addedCommunityMap(Community community, Manager manager){
        CreateCommunityResponse createCommunityResponse = new CreateCommunityResponse();
        createCommunityResponse.setCommunityId(community.getCommunityId());
        createCommunityResponse.setCommunityName(community.getCommunityName());
        createCommunityResponse.setCommunityManagerName(manager.getCommunityMgrName());
        createCommunityResponse.setCommunityDesc(community.getCommunityDesc());
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
}
