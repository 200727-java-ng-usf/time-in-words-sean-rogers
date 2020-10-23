package com.revature.services;

import com.revature.entities.AppEntity;
import com.revature.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    @Transactional
    public List<AppEntity> findAll() {
        Iterable<AppEntity> entitiesIterable = appRepository.findAll();
        List<AppEntity> entitiesList = new ArrayList<>();
        entitiesIterable.forEach((appEntity) -> entitiesList.add(appEntity));

        return entitiesList;
    }

}
