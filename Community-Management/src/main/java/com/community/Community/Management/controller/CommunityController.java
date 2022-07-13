package com.community.Community.Management.controller;

import com.community.Community.Management.model.Community;
import com.community.Community.Management.model.CommunityDTO;
import com.community.Community.Management.model.CommunityManager;
import com.community.Community.Management.response.FailedCommunityResponse;
import com.community.Community.Management.response.ApiExceptionHandler;
import com.community.Community.Management.service.CommunityManagerService;
import com.community.Community.Management.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;
    @Autowired
    private CommunityManagerService  communityManagerService;

    @PostMapping
    public ResponseEntity<Object> createNewCommunity(@RequestBody CommunityDTO communityDTO) {
        Optional<Community> optionalCommunity = Optional.ofNullable(communityService.findCommunityByName(communityDTO.getCommunityName()));
            if (optionalCommunity.isPresent()) {
                FailedCommunityResponse message = new FailedCommunityResponse();
                return ApiExceptionHandler.negativeResponse(message, HttpStatus.BAD_REQUEST);
             } else {
                Optional<CommunityManager> newCommunityManager = Optional.ofNullable(communityManagerService.getCommunityManagerByID(communityDTO.getCommunityManagerId()));
                if (newCommunityManager.isPresent()) {
                    Community community = communityService.createNewCommunity(communityDTO);
                    return ApiExceptionHandler.positiveResponse(community,newCommunityManager.get(), HttpStatus.OK);
                }
                FailedCommunityResponse message = new FailedCommunityResponse();
                return ApiExceptionHandler.negativeResponse(message, HttpStatus.NOT_FOUND);
            }
    }
}

