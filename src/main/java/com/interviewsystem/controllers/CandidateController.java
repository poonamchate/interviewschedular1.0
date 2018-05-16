package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Candidate;
//import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.services.CandidateService;
//import com.interviewsystem.services.InterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {


    @Autowired
    private CandidateService candidateService;

    // Interviewer CRUD
    @RequestMapping(method = RequestMethod.POST,value= "/candidate")
    public Candidate create(@RequestBody Candidate candidate){

        return candidateService.create(candidate);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/candidate/")
    public List<Candidate> readAll(){

        return candidateService.getAll();

    }

    @RequestMapping(method = RequestMethod.GET,value= "/candidate/{iid}")
    public Candidate read(@PathVariable int iid){
        return candidateService.getByID(iid);

    }

    @RequestMapping(method = RequestMethod.PUT,value= "/candidate")
    public Candidate update(@RequestBody Candidate candidate){

        return candidateService.update(candidate);

    }

    @RequestMapping(method = RequestMethod.DELETE,value= "/candidate")
    public void delete(@RequestBody int iid){

        candidateService.delete(iid);

    }



}
