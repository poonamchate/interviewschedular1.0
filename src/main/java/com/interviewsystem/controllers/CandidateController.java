package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.requests.CandidateDto;
import com.interviewsystem.models.requests.CandidateScheduleDto;
import com.interviewsystem.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = "http://localhost:9090")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.POST,value= "/")
    public Candidate createCandidate(@RequestBody CandidateDto candidateDto){

        return candidateService.create(candidateDto);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/")
    public List<Candidate> getCandidates(){

        return candidateService.getAll();

    }

    @RequestMapping(method = RequestMethod.GET,value= "/id/{iid}")
    public Candidate getCandidateById(@PathVariable int iid){
        return candidateService.getByID(iid);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/name/{name}")
    public List<Candidate> getCandidateByName(@PathVariable String name){
        return candidateService.getByName(name);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/email/{email}")
    public List<Candidate> getCandidateByEmail(@PathVariable String email){

        return candidateService.getByEmail(email);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/experience/{expYears}")
    public List<Candidate> getCandidateByExperience(@PathVariable int expYears){

        return candidateService.getByExperience(expYears);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/contact/{contact}")
    public List<Candidate> getCandidateByContact(@PathVariable int contact){

        return candidateService.getByContact(contact);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/priority/{priority}")
    public List<Candidate> getCandidateByPriority(@PathVariable String priority){

        return candidateService.getByPriority(priority);
    }

    @RequestMapping(method = RequestMethod.PUT,value= "/")
    public Candidate updateCandidate(@RequestBody CandidateDto candidateDto){

        return candidateService.update(candidateDto);

    }

    @RequestMapping(method = RequestMethod.DELETE,value= "/")
    public void deleteCandidate(@RequestBody int iid){

        candidateService.delete(iid);

    }

    @RequestMapping(method = RequestMethod.POST , value = "/schedule")
    public void scheduleCandidate(@RequestBody CandidateScheduleDto schedule){

        candidateService.schedule(schedule);
    }
}
