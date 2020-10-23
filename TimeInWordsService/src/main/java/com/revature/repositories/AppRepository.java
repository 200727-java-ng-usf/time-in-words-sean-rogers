package com.revature.repositories;

import com.revature.entities.AppEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends CrudRepository<AppEntity, Integer> {



}
