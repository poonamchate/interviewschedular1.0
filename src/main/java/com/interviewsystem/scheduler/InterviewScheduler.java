package com.interviewsystem.scheduler;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.CandidateSchdule;
import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.entity.InterviewerSchdule;
import com.interviewsystem.repository.CandidateScheduleRepository;
import com.interviewsystem.repository.InterviewerSechduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

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

        Map<Date, List<Interviewer>> interviewerMap = new HashMap<>();
        Map<Date, List<Candidate>> candidateMap = new HashMap<>();

        Map<Date, List<InterviewerSlot>> interviewerMap1 = new HashMap<>();

        interviewerMap1= interviewerData.stream().collect(groupingBy(i -> i.getDate() , mapping((InterviewerSchdule i) ->
        new InterviewerSlot(i.getInterviewer(),i.getSlot()), toList())));

        System.out.println("interviewerMap1:" + interviewerMap1);

        interviewerMap= interviewerData.stream().collect(groupingBy(i -> i.getDate() , mapping((InterviewerSchdule i) -> i.getInterviewer(), toList())));
        candidateMap = candidateData.stream().collect(groupingBy(c -> c.getDate(), mapping((CandidateSchdule c) -> c.getCandidate(), toList())));

        System.out.println("interviewerMap:" + interviewerMap);
        System.out.println("candidateMap:" + candidateMap);

        for (Map.Entry<Date, List<Interviewer>> entry : interviewerMap.entrySet()){
            Date date = entry.getKey();
                List<Candidate> candidateList = candidateMap.get(date);
                List<Interviewer> interviewerList = entry.getValue();
                if(candidateList.isEmpty() || interviewerList.isEmpty()){
                    continue;
                }else{
                    for(Interviewer interviewer : interviewerList){
                        String priority = interviewer.getPriority();
                        if(priority.equals("P1")){
                           /* List<String> slots = InterviewerRepository.findSlotByInterviewerAndDate(interviewer, date);*/

                        }
                    }
                }
            }
    }
}
