package com.revature.services;

import com.revature.entities.AppEntity;
import com.revature.repositories.AppRepository;
import com.revature.web.dtos.TimeDTO;
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

    @Transactional
    public AppEntity save(AppEntity appEntity) {

        if(appEntity == null) {
            throw new RuntimeException("AppEntity is null in AppService");
        }

        appEntity = appRepository.save(appEntity);
        return appEntity;
    }

    @Transactional
    public String getStringTimeFormat(TimeDTO timeDTO) {

        int h = timeDTO.getHours();
        int m = timeDTO.getMinutes();

        String hour = "";
        String minute = "";

        String returnString = "";

        String[] strings = {"one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty one",
                "twenty two",
                "twenty three",
                "twenty four",
                "twenty five",
                "twenty six",
                "twenty seven",
                "twenty eight",
                "twenty nine",
                "thrity"
        };

        hour = strings[h-1];

        if (m <= 30) {
            if(m == 0) {
                return hour + " " + "o' clock";
            }
            if(m != 0) {
                minute = strings[m - 1] + " minutes past";
            }
            if(m == 1) {
                minute = "one minute past";
            }
            if(m == 15) {
                minute = "quarter past";
            }
            if(m == 30) {
                minute = "half past";
            }

            return minute + " " + hour;
        }

        if(m > 30) {

            hour = strings[h];
            if(h == 12) {
                hour = "one";
            }


            minute = strings[60 - m - 1] + " minutes to";

            if(m == 45) {
                minute = "quarter to";
            }

            if(m == 59) {
                minute = "one minute to";
            }

            return minute + " " + hour;
        }



        return "shouldn't have made it here";

    }

}
