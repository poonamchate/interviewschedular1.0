package com.interviewsystem.services;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.CandidateSchdule;
import com.interviewsystem.models.enums.Priority;
import com.interviewsystem.models.requests.CandidateDto;
import com.interviewsystem.models.requests.CandidateScheduleDto;
import com.interviewsystem.repository.CandidateRepository;
import com.interviewsystem.repository.CandidateScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CandidateScheduleRepository candidateScheduleRepository;

    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }

    public Candidate create(CandidateDto candidateDto){

        Candidate candidateData = new Candidate();
        candidateData.setExpYears(candidateDto.getExpYears());
        candidateData.setName(candidateDto.getName());
        String priority = candidateDto.getExpYears() >= 5 ? Priority.PRIORITY1.getPriority() : Priority.PRIORITY2.getPriority();
        candidateData.setPriority(priority);
        candidateData.setContact(candidateDto.getContact());
        candidateData.setEmail(candidateDto.getEmail());

        return candidateRepository.save(candidateData);
    }
    public Candidate update(CandidateDto candidateDto){

        return create(candidateDto);
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

    public void schedule(CandidateScheduleDto schedule){

        CandidateSchdule scheduleData = new CandidateSchdule();
        scheduleData.setCandidate(candidateRepository.findById(schedule.getCid()).get());
        scheduleData.setDate(schedule.getDate());
        scheduleData.setScheduled(false);
        candidateScheduleRepository.save(scheduleData);
    }

    @PostConstruct
    public void dataPopulation(){
        Candidate candidate = new Candidate();
        candidate.setName("nishant");
        candidate.setContact(26532653);
        candidate.setExpYears(5);
        candidate.setPriority("P1");
        candidate.setEmail("test@gmail.com");
        candidateRepository.save(candidate);
    }
}
