package com.revature.controllers;

import com.revature.entities.AppEntity;
import com.revature.services.AppService;
import com.revature.web.dtos.TimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entities")
public class AppController {

    @Autowired
    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppEntity> getAllEntities() {
        return appService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AppEntity saveEntity(@RequestBody AppEntity appEntity) {

        return appService.save(appEntity);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTime(@RequestBody TimeDTO timeDTO) {

        return appService.getStringTimeFormat(timeDTO);

    }



}
