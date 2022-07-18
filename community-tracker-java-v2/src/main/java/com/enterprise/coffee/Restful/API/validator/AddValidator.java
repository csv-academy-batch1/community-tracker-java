package com.enterprise.coffee.Restful.API.validator;

import com.enterprise.coffee.Restful.API.exception.CommunityException;
import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddValidator {

    @Autowired
    private CommunityRepository communityRepository;

    public void validateCommunityName(Community community) {
        Optional<Community> communityOptional = Optional.ofNullable(communityRepository.findByCommunityName(community.getCommunityName()));
        if (communityOptional.isPresent()) {
            throw new CommunityException();
        }
    }
}


