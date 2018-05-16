package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Interviewer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedularController {

    private
    @RequestMapping(method = RequestMethod.POST,value= "/schedular")
    public Interviewer createInterviewer(@RequestBody Interviewer interviewer){

        return interviewerService.create(interviewer);

    }

}
