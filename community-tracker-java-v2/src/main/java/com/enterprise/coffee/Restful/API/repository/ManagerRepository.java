package com.enterprise.coffee.Restful.API.repository;

import com.enterprise.coffee.Restful.API.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
