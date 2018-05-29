package com.interviewsystem.controllers;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.requests.CandidateDto;
import com.interviewsystem.models.requests.CandidateScheduleDto;
import com.interviewsystem.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = "http://localhost:9090")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.POST,value= "/")
    public ResponseEntity<Candidate> createCandidate(@RequestBody CandidateDto candidateDto){

        return new ResponseEntity<>(candidateService.create(candidateDto), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/")
    public ResponseEntity<List<Candidate>> getCandidates(){

        return new ResponseEntity<>(candidateService.getAll(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET,value= "/id/{iid}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable int iid){

        return new ResponseEntity<>(candidateService.getByID(iid), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/name/{name}")
    public ResponseEntity<List<Candidate>> getCandidateByName(@PathVariable String name){
        return new ResponseEntity<>(candidateService.getByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/email/{email}")
    public ResponseEntity<List<Candidate>> getCandidateByEmail(@PathVariable String email){

        return new ResponseEntity<>(candidateService.getByEmail(email), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/experience/{expYears}")
    public ResponseEntity<List<Candidate>> getCandidateByExperience(@PathVariable int expYears){

        return new ResponseEntity<>(candidateService.getByExperience(expYears), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/contact/{contact}")
    public ResponseEntity<List<Candidate>> getCandidateByContact(@PathVariable int contact){

        return new ResponseEntity<>(candidateService.getByContact(contact), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value= "/priority/{priority}")
    public ResponseEntity<List<Candidate>> getCandidateByPriority(@PathVariable String priority){

        return new ResponseEntity<>(candidateService.getByPriority(priority), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,value= "/")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody CandidateDto candidateDto){

        return new ResponseEntity<>(candidateService.update(candidateDto), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE,value= "/{cid}")
    public void deleteCandidate(@PathVariable int cid){

        candidateService.delete(cid);

    }

    @RequestMapping(method = RequestMethod.POST , value = "/schedule")
    public void scheduleCandidate(@RequestBody CandidateScheduleDto schedule){

        candidateService.schedule(schedule);
    }
}
