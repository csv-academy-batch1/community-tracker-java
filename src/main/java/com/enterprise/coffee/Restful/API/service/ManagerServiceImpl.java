package com.enterprise.coffee.Restful.API.service;

import com.enterprise.coffee.Restful.API.model.Manager;
import com.enterprise.coffee.Restful.API.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager findManagerById(Long id) {
            Optional<Manager> communityManager = managerRepository.findById(id);
            return communityManager.orElse(null);
        }
}
