package com.enterprise.coffee.Restful.API.controller;

import com.enterprise.coffee.Restful.API.mapper.OutputCommunityMap;
import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.model.CreateCommunityResponse;
import com.enterprise.coffee.Restful.API.model.GetCommunityResponse;
import com.enterprise.coffee.Restful.API.model.Manager;
import com.enterprise.coffee.Restful.API.service.CommunityService;
import com.enterprise.coffee.Restful.API.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class communityController {

    @Autowired
    private CommunityService communityService;
    @Autowired
    private OutputCommunityMap outputCommunityMap;
    @Autowired
    private ManagerService managerService;

    @GetMapping
    ResponseEntity<GetCommunityResponse> getAllCommunity(){
        List<Community> communityList = communityService.getAllCommunity();
        return new ResponseEntity<>(outputCommunityMap.activeCommunityMap(communityList), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<CreateCommunityResponse> createCommunity(@RequestBody Community community) {
        Manager manager = managerService.findManagerById(community.getCommunityManagerId());
        communityService.createCommunity(community);
        return new ResponseEntity<>(outputCommunityMap.addedCommunityMap(community, manager), HttpStatus.CREATED);
    }
}
