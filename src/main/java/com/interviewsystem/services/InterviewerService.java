package com.interviewsystem.services;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.entity.InterviewerSchdule;
import com.interviewsystem.models.enums.Priority;
import com.interviewsystem.models.requests.InterviewerDto;
import com.interviewsystem.models.requests.InterviewerSechduleDto;
import com.interviewsystem.repository.InterviewerRepository;
import com.interviewsystem.repository.InterviewerSechduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewerService {

    @Autowired
    InterviewerRepository interviewerRepository;

    @Autowired
    InterviewerSechduleRepository interviewerSechduleRepository;

    public List<Interviewer> getAll(){
        return interviewerRepository.findAll();
    }

    public Interviewer create(InterviewerDto interviewerDto){

        Interviewer interviewerData = new Interviewer();
        interviewerData.setName(interviewerDto.getiName());
        if(interviewerDto.getPriority() == null){
            interviewerData.setPriority(Priority.PRIORITY1.getPriority());
        }else {
            interviewerData.setPriority(interviewerDto.getPriority().getPriority());
        }if(interviewerDto.getContact() == 0){
            interviewerData.setContact(12345);
        }else {
            interviewerData.setContact(interviewerDto.getContact());
        }
        interviewerData.setEmail(interviewerDto.getEmail());
        return interviewerRepository.save(interviewerData);
    }
    public Interviewer update(InterviewerDto interviewerDto){

        return create(interviewerDto);
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

    public void schedule(InterviewerSechduleDto schedule){

        InterviewerSchdule scheduleData = new InterviewerSchdule();
        Interviewer interviewer = interviewerRepository.findById(schedule.getIid()).get();
        scheduleData.setInterviewer(interviewer);
        scheduleData.setDate(schedule.getDate());
        scheduleData.setSlot(schedule.getSlot().getSlot());
        scheduleData.setScheduled(false);
        interviewerSechduleRepository.save(scheduleData);
    }

    @PostConstruct
    public void dataPopulation(){
        Interviewer interviewer = new Interviewer();
        interviewer.setName("nishant");
        interviewer.setPriority(Priority.PRIORITY1.getPriority());
        interviewer.setEmail("test@gmail.com");
        interviewerRepository.save(interviewer);
    }
}
