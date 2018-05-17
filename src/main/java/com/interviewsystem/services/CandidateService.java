package com.interviewsystem.services;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.enums.Priority;
import com.interviewsystem.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }

    public Candidate create(com.interviewsystem.models.requests.Candidate candidate){

        Candidate candidateData = new Candidate();
        candidateData.setExpYears(candidate.getExpYears());
        candidateData.setName(candidate.getName());
        String priority = candidate.getExpYears() >= 5 ? Priority.PRIORITY1.getPriority() : Priority.PRIORITY2.getPriority();
        candidateData.setPriority(priority);
        candidateData.setContact(candidate.getContact());
        candidateData.setEmail(candidate.getEmail());

        return candidateRepository.save(candidateData);
    }
    public Candidate update(com.interviewsystem.models.requests.Candidate candidate){

        return create(candidate);
    }

    public Candidate getByID(int id){

        return candidateRepository.findById(id).get();
    }

    public List<Candidate> getByName(String name){

        return candidateRepository.findByName(name);
    }

    public List<Candidate> getByExperience(int exp){

        return candidateRepository.findByExpYears(exp);
    }
    public List<Candidate> getByEmail(String email){

        return candidateRepository.findByEmail(email);
    }

    public List<Candidate> getByContact(int contact){

        return candidateRepository.findByContact(contact);
    }

    public List<Candidate> getByPriority(String priority){

        return candidateRepository.findByPriority(priority);
    }
    public void delete(int id){

        candidateRepository.deleteById(id);
    }

}
