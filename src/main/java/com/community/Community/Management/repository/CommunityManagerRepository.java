package com.community.Community.Management.repository;

import com.community.Community.Management.model.CommunityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityManagerRepository extends JpaRepository<CommunityManager, Integer> {

}
