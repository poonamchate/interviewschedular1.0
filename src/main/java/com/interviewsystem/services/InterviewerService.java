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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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
        }if(interviewerDto.getContact() == null){
            interviewerData.setContact("12345");
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
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localdate = schedule.getDate().toInstant().atZone(defaultZoneId).toLocalDate();
        scheduleData.setDate(Date.from(LocalDate.of(localdate.getYear(),localdate.getMonth(),localdate.getDayOfMonth()).atStartOfDay(defaultZoneId).toInstant()));
        scheduleData.setDate(schedule.getDate());
        scheduleData.setSlot(schedule.getSlot().getSlot());
        scheduleData.setScheduled(false);
        interviewerSechduleRepository.save(scheduleData);
    }


    @PostConstruct
    public void dataPopulation(){

        for(int i = 0;i <2 ; i++) {
            Interviewer interviewer = new Interviewer();
            interviewer.setName("Poonam"+i);
            interviewer.setPriority(Priority.PRIORITY1.getPriority());
            interviewer.setEmail("test@gmail.com");
            interviewerRepository.save(interviewer);


            // interviewer slot dummy data
            InterviewerSchdule interviewerSchdule = new InterviewerSchdule();
            interviewerSchdule.setScheduled(false);
            interviewerSchdule.setInterviewer(interviewer);
            if(i==0)
                interviewerSchdule.setDate(Date.from(LocalDate.of(2018, 5, 21).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            else
                interviewerSchdule.setDate(Date.from(LocalDate.of(2018, 5, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            interviewerSchdule.setSlot("S2");
            interviewerSechduleRepository.save(interviewerSchdule);

        }
    }
}
