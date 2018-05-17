package com.interviewsystem.services;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.enums.Priority;
import com.interviewsystem.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewerService {

    @Autowired
    InterviewerRepository interviewerRepository;
    public List<Interviewer> getAll(){
        return interviewerRepository.findAll();
    }

    public Interviewer create(com.interviewsystem.models.requests.Interviewer interviewer){

        Interviewer interviewerData = new Interviewer();
        interviewerData.setName(interviewer.getiName());
        interviewerData.setPriority(interviewer.getPriority().getPriority());
        interviewerData.setContact(interviewer.getContact());
        interviewerData.setEmail(interviewer.getEmail());
        return interviewerRepository.save(interviewerData);
    }
    public Interviewer update(com.interviewsystem.models.requests.Interviewer interviewer){

        return create(interviewer);
    }

    public Interviewer getByID(int id){

        return interviewerRepository.findById(id).get();
    }

    public List<Interviewer> getByName(String name){
        return  interviewerRepository.findByName(name);
    }

    public List<Interviewer> getByEmail(String email){
        return  interviewerRepository.findByEmail(email);
    }

    public List<Interviewer> getByContact(int contact){
        return  interviewerRepository.findByContact(contact);
    }

    public List<Interviewer> getByPriority(Priority priority){
        return  interviewerRepository.findByPriority(priority.getPriority());
    }
    public void delete(int id){

         interviewerRepository.deleteById(id);
    }

}
