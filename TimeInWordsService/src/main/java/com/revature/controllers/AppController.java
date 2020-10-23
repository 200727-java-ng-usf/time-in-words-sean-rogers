package com.revature.controllers;

import com.revature.entities.AppEntity;
import com.revature.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entities")
public class AppController {

    @Autowired
    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppEntity> getAllEntities() {
        return appService.findAll();
    }

}
