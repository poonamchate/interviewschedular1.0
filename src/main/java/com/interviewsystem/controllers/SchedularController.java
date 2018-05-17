package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.services.SchedularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedularController {

    @Autowired
    private SchedularService schedularService;

    @RequestMapping(method = RequestMethod.POST,value= "/schedular")
    public void showInterviewSchedule(){

        schedularService.showSchedule();
    }
}
