package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.services.InterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewerController {

    @Autowired
    private InterviewerService interviewerService;

    // Interviewer CRUD
    @RequestMapping(method = RequestMethod.POST,value= "/interviewer")
    public Interviewer createInterviewer(@RequestBody Interviewer interviewer){

        return interviewerService.create(interviewer);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/interviewer/")
    public List<Interviewer> readAllInterviewer(){

        return interviewerService.getAll();

    }

    @RequestMapping(method = RequestMethod.GET,value= "/interviewer/{iid}")
    public Interviewer readInterviewer(@PathVariable int iid){
        return interviewerService.getByID(iid);

    }

    @RequestMapping(method = RequestMethod.PUT,value= "/interviewer")
    public Interviewer updateInterviewer(@RequestBody Interviewer interviewer){

       return interviewerService.update(interviewer);

    }

    @RequestMapping(method = RequestMethod.DELETE,value= "/interviewer")
    public void deleteInterviewer(@RequestBody int iid){

        interviewerService.delete(iid);

    }

}
