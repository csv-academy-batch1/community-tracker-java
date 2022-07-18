package com.enterprise.coffee.Restful.API.repository;

import com.enterprise.coffee.Restful.API.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    Community findByCommunityName(String name);

    List<Community> getCommunityByStatus(boolean status);

}
