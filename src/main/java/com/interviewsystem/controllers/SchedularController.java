package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.requests.SchedularDto;
import com.interviewsystem.services.SchedularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class SchedularController {

    @Autowired
    private SchedularService schedularService;

    @RequestMapping(method = RequestMethod.GET,value= "/schedular")
    public List<SchedularDto> showInterviewSchedule(){

        return schedularService.showSchedule();
    }
}
