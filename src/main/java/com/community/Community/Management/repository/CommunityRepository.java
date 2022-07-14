package com.community.Community.Management.repository;

import com.community.Community.Management.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
        Community findByCommunityName(String name);
}
