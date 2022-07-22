package com.enterprise.coffee.Restful.API.validator;

import com.enterprise.coffee.Restful.API.exception.CommunityException;
import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.model.Manager;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import com.enterprise.coffee.Restful.API.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommunityValidator {

    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private ManagerRepository managerRepository;

    public void validateCommunityName(Community community) {
        Optional<Community> communityOptional = Optional.ofNullable(communityRepository.findByCommunityNameIgnoreCase(community.getCommunityName()));
        if (communityOptional.isPresent()) {
            System.out.println("Community name exist!");
            throw new CommunityException();
        }
    }

    public void validateCommunityId(Community community){
        Optional<Community> communityOptional = communityRepository.findById(community.getCommunityId());
        if (communityOptional.isEmpty()) {
            System.out.println("Community ID not exist!");
            throw new CommunityException();
        }
    }

    public void validateCommunityManager(Community community) {
        Optional<Manager> managerOptional = managerRepository.findById(community.getCommunityMgrid());
        if (managerOptional.isEmpty()) {
            System.out.println("Community Manager not exist!");
            throw new CommunityException();
        }
    }

    public void validateCommunityIdForUpdate(Community community, Long id){
        //if (community.getCommunityId() != id) {
        if (community.getCommunityId().longValue() != id.longValue()) {
            System.out.println("Community ID  and  Endpoint doest match!");
            System.out.println(community.getCommunityId());
            System.out.println(id);
            throw new CommunityException();
        }
    }

    public void validateCommunityIsActive(Long id){
        Optional<Community> communityOptional = communityRepository.findById(id);
        if (communityOptional.get().getIsActive().equals(false)) {
            System.out.println("Community is not active!");
           throw new CommunityException();
        }
    }

    public void validateUpdateCommunityName(Community community, Long id) {
        Optional<Community> communityOptional = Optional.ofNullable(communityRepository.findByCommunityNameIgnoreCase(community.getCommunityName()));
        if (communityOptional.isPresent()) {
           if(communityOptional.get().getCommunityId() != id) {
             System.out.println("Community name doesn't match to the community id! and Community Name is already exist");
            throw new CommunityException();
           }
        }
    }
}


