package com.community.Community.Management.service;


import com.community.Community.Management.model.Community;
import com.community.Community.Management.model.CommunityDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityService {

    Community createNewCommunity(CommunityDTO communityDTO);

    Community findCommunityByName(String name);

}
