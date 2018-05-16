package com.interviewsystem.services;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InterviewerService {

    @Autowired
    InterviewerRepository interviewerRepository;
    public List<Interviewer> getAll(){
        return interviewerRepository.findAll();
    }

    public Interviewer create(Interviewer interviewer){

        return interviewerRepository.save(interviewer);
    }
    public Interviewer update(Interviewer interviewer){

        return create(interviewer);
    }

    public Interviewer getByID(int id){

        return interviewerRepository.findById(id).get();
    }

    public void delete(int id){

         interviewerRepository.deleteById(id);
    }

}
