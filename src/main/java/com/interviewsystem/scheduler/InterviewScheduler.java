package com.interviewsystem.scheduler;

import com.interviewsystem.models.entity.CandidateSchdule;
import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.entity.InterviewerSchdule;
import com.interviewsystem.repository.CandidateScheduleRepository;
import com.interviewsystem.repository.InterviewerSechduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InterviewScheduler {

    @Autowired
    InterviewerSechduleRepository InterviewerRepository;

    @Autowired
    CandidateScheduleRepository candidateRepository;

    @Scheduled(cron = "${cron.expression}")
    public void scheduleInterviews(){

        List<InterviewerSchdule> interviewerData =  InterviewerRepository.findByIsScheduledFalse();
        List<CandidateSchdule> candidateData = candidateRepository.findByIsScheduledFalse();

        Map<Date, Interviewer> interviewerMap = new HashMap<>();

        for(InterviewerSchdule interviewer :interviewerData){

            interviewer.getInterviewer();
        }

    }
}
