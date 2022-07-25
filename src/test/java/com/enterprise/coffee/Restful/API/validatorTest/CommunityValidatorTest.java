package com.enterprise.coffee.Restful.API.validatorTest;

import com.enterprise.coffee.Restful.API.exception.CommunityException;
import com.enterprise.coffee.Restful.API.model.Community;
import com.enterprise.coffee.Restful.API.model.Manager;
import com.enterprise.coffee.Restful.API.repository.CommunityRepository;
import com.enterprise.coffee.Restful.API.repository.ManagerRepository;
import com.enterprise.coffee.Restful.API.validator.CommunityValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CommunityValidatorTest {

    @Autowired
    private CommunityValidator validator;
    @MockBean
    private CommunityRepository communityRepository;

    @MockBean
    private ManagerRepository managerRepository;


    @Test
    @DisplayName("testValidateCommunityName_CommunityNameIsAlreadyExisting_ThrowCommunityException")
    public void validateCommunityNameTest() throws CommunityException{
        Community community = new Community(1L,"restan","icon2",1L,"description2",true);
        when(communityRepository.save(new Community(1L,"Restan","icon1",1L,"description2",true))).thenReturn(community);
        when(communityRepository.findByCommunityNameIgnoreCase(community.getCommunityName())).thenReturn(community);

        Assertions.assertThrows(CommunityException.class, () -> {
            validator.validateCommunityName(community);

        });
    }

    @Test
    @DisplayName("testValidateCommunityId_CommunityIdIsNotExisting_ThrowCommunityException")
    public void validateCommunityIdTest() throws CommunityException{
        Community community = new Community(6L,"jade","icon2",1L,"description2",true);
        when(communityRepository.save(new Community(1L,"Restan","icon1",1L,"description2",true))).thenReturn(community);
        when(communityRepository.findById(7L)).thenReturn(Optional.of(community));

        Assertions.assertThrows(CommunityException.class, () -> {
            validator.validateCommunityId(community);
        });
    }

    @Test
    @DisplayName("testValidateCommunityManager_CommunityMgridIsNotExisting_ThrowCommunityException")
    public void validateCommunityManagerTest() throws CommunityException{
        Community community = new Community(1L,"jade","icon2",6L,"description2",true);
        when(managerRepository.save(new Manager(1L,"jade"))).thenReturn(new Manager());
        when(communityRepository.findById(community.getCommunityMgrid())).thenReturn(Optional.of(community));

        Assertions.assertThrows(CommunityException.class, () -> {
            validator.validateCommunityManager(community);
        });
    }

    @Test
    @DisplayName("testValidateCommunityIdForUpdate_CommunityIdAndEndpointIdIsNotMatch_ThrowCommunityException")
    public void validateCommunityIdForUpdateTest() throws CommunityException{
        Long id = 9L;
        Community community = new Community(1L,"jade","icon2",6L,"description2",true);

        Assertions.assertThrows(CommunityException.class, () -> {
            validator.validateCommunityIdForUpdate(community,id);
        });
    }

    @Test
    @DisplayName("testValidateCommunityIsActive_CommunityStatusIsFalse_ThrowCommunityException")
    public void validateCommunityIsActiveTest() throws CommunityException{
        Long id = 1L;
        Community community = new Community(1L,"jade","icon2",6L,"description2",false);
        when(communityRepository.save(new Community(1L,"Restan","icon1",1L,"description2",false))).thenReturn(community);
        when(communityRepository.findById(1L)).thenReturn(Optional.of(community));

        assertThrows(CommunityException.class, () -> {
            validator.validateCommunityIsActive(id);
        });
    }

    @Test
    @DisplayName("testValidateCommunityName_CommunityNameIsExistingWithDifferentId_ThrowCommunityException")
    public void validateUpdateCommunityNameTest() throws CommunityException{
        Long id = 2L;
        Community community = new Community(1L,"restan","icon2",6L,"description2",true);
        when(communityRepository.save(new Community(1L,"Restan","icon1",1L,"description2",false))).thenReturn(new Community());
        when(communityRepository.findByCommunityNameIgnoreCase(community.getCommunityName())).thenReturn(community);

        assertThrows(CommunityException.class, () -> {
            validator.validateUpdateCommunityName(community, id);
        });
    }



}
