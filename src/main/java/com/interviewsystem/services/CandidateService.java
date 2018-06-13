package com.interviewsystem.services;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.CandidateSchdule;
import com.interviewsystem.models.enums.Priority;
import com.interviewsystem.models.exceptions.InvalidDataException;
import com.interviewsystem.models.requests.CandidateDto;
import com.interviewsystem.models.requests.CandidateScheduleDto;
import com.interviewsystem.repository.CandidateRepository;
import com.interviewsystem.repository.CandidateScheduleRepository;
import com.interviewsystem.repository.SchedularRepository;
import com.interviewsystem.util.Constants;
import com.interviewsystem.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CandidateScheduleRepository candidateScheduleRepository;

    @Autowired
    SchedularRepository schedularRepository;

    @Value("${priority.p1}")
    private int priority1;

    @Value("${priority.p2}")
    private int priority2;

    @Value("#{'${priority.list}'.split(',')}")
    private List<String> priorityList;

    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }

    public Candidate create(CandidateDto candidateDto){

        if(candidateDto.getExpYears() <= 0 || candidateDto.getContact() == null  ||
           candidateDto.getEmail() == null || candidateDto.getName() == null
           /*|| !(ValidationUtil.validateName(candidateDto.getName()))
           || !(ValidationUtil.validateEmail(candidateDto.getEmail()))*/){

            throw new InvalidDataException(Constants.INVALID_DATA, "E01");
        }
        Candidate candidateData = new Candidate();
        candidateData.setExpYears(candidateDto.getExpYears());
        candidateData.setName(candidateDto.getName());
        String priority = candidateDto.getExpYears() >= priority1 ? Priority.PRIORITY1.getPriority() : Priority.PRIORITY2.getPriority();
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

        if(name == null){
            throw new InvalidDataException(Constants.INVALID_DATA, "E01");
        }
        return candidateRepository.findByName(name);
    }

    public List<Candidate> getByExperience(int exp){

        return candidateRepository.findByExpYears(exp);
    }
    public List<Candidate> getByEmail(String email){

        if(email == null){
            throw new InvalidDataException(Constants.INVALID_DATA, "E01");
        }
        return candidateRepository.findByEmail(email);
    }

    public List<Candidate> getByContact(int contact){

        return candidateRepository.findByContact(contact);
    }

    public List<Candidate> getByPriority(String priority){

        if(priority == null){
            throw new InvalidDataException(Constants.INVALID_DATA, "E01");
        }
        return candidateRepository.findByPriority(priority);
    }
    @Transactional
    public void delete(int id){

        Candidate candidate = getByID(id);
        if(candidateScheduleRepository.existsByCandidate(candidate)){
            if(schedularRepository.existsByCid(candidate)){
                schedularRepository.deleteByCid(candidate);
            }

            candidateScheduleRepository.deleteByCandidate(candidate);
        }else{
            candidateRepository.deleteById(id);
        }
    }

    public void schedule(CandidateScheduleDto schedule){

        CandidateSchdule scheduleData = new CandidateSchdule();
        scheduleData.setCandidate(candidateRepository.findById(schedule.getCid()).get());
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localdate = schedule.getDate().toInstant().atZone(defaultZoneId).toLocalDate();
        scheduleData.setDate(Date.from(LocalDate.of(localdate.getYear(),localdate.getMonth(),localdate.getDayOfMonth()).atStartOfDay(defaultZoneId).toInstant()));
        scheduleData.setScheduled(false);
        candidateScheduleRepository.save(scheduleData);

        /*schedule.getDate()
        Date.from(LocalDate.of(2018,5,21).atStartOfDay(ZoneId.systemDefault()).toInstant())*/
    }

    @PostConstruct
    public void dataPopulation(){

        for(int i = 0;i <10 ; i++) {
            Candidate candidate = new Candidate();
            candidate.setName("nishant"+i);
            candidate.setContact("26532653");
            candidate.setExpYears(i+1);
            String priority = candidate.getExpYears() >= 5 ? Priority.PRIORITY1.getPriority() : Priority.PRIORITY2.getPriority();
            candidate.setPriority(priority);
            candidate.setEmail("test@gmail.com");
            candidateRepository.save(candidate);


            // candidate slot dummy data
            CandidateSchdule candidateSchdule = new CandidateSchdule();
            candidateSchdule.setScheduled(false);
            candidateSchdule.setCandidate(candidate);
            if(i <= 4)
                candidateSchdule.setDate(Date.from(LocalDate.of(2018, 5, 21).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            else if(i > 5 && i < 8)
                candidateSchdule.setDate(Date.from(LocalDate.of(2018, 5, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            else
                candidateSchdule.setDate(Date.from(LocalDate.of(2018, 5, 23).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            candidateScheduleRepository.save(candidateSchdule);
        }
    }
}
