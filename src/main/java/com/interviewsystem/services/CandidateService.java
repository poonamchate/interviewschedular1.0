package com.interviewsystem.services;

import com.interviewsystem.models.entity.Candidate;
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

    public Candidate create(Candidate candidate){

        return candidateRepository.save(candidate);
    }
    public Candidate update(Candidate candidate){

        return create(candidate);
    }

    public Candidate getByID(int id){

        return candidateRepository.findById(id).get();
    }

    public void delete(int id){

        candidateRepository.deleteById(id);
    }

}
