package com.enterprise.coffee.Restful.API.serviceImplTest;

import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.model.Manager;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import com.enterprise.coffee.Restful.API.repository.ManagerRepository;
import com.enterprise.coffee.Restful.API.service.CommunityService;
import com.enterprise.coffee.Restful.API.service.ManagerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CommunityServiceImplTest {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private ManagerService managerService;

    @MockBean
    private CommunityRepository communityRepository;

    @MockBean
    private ManagerRepository managerRepository;

    @Test
    @DisplayName("testGetAllCommunity_FilteredByStatusActive_SizeIsEqualsToTwo")
    public void getAllCommunityPositiveTest(){
        when(communityRepository.getCommunityByIsActive(true)).thenReturn(Stream.of(new Community(1L,"Restan","icon1",1L,"description",true)
                , new Community(2L,"Jade","icon2",2L,"description1",true)).collect(Collectors.toList()));

        assertEquals(2, communityService.getAllCommunity().size());
    }

    @Test
    @DisplayName("testCreateCommunity_GivenValidData_ResponseIsSameAsCreateNewCommunity")
    public void createCommunityPositiveTest(){

        Community community = new Community(1L,"Restan","icon1",1L,"description",true);
        when(managerRepository.findById(community.getCommunityId())).thenReturn(Optional.of(new Manager(1L, "zayn")));
        when(communityRepository.save(community)).thenReturn(community);

        assertEquals(community, communityService.createCommunity(community));
    }

    @Test
    @DisplayName("testUpdateCommunity_UpdateCommunityName_ShouldReplaceNameWithRequestCommunityName")
    public void updateCommunityPositiveTest(){

        Long id = 1L;
        Community community = new Community(1L,"Restan","icon1",1L,"description",true);
        when(managerRepository.findById(community.getCommunityId())).thenReturn(Optional.of(new Manager(1L, "zayn")));
        when(communityRepository.save(community)).thenReturn(community);
        when(communityRepository.findById(community.getCommunityId())).thenReturn(Optional.of(new Community(1L, "Jade", "icon1", 1L, "description", true)));

        assertEquals(community, communityService.updateCommunity(community,id));

    }


}
