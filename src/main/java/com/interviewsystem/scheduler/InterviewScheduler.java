package com.interviewsystem.scheduler;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.CandidateSchdule;
import com.interviewsystem.models.entity.InterviewerSchdule;
import com.interviewsystem.models.entity.Schedular;
import com.interviewsystem.repository.CandidateScheduleRepository;
import com.interviewsystem.repository.InterviewerSechduleRepository;
import com.interviewsystem.repository.SchedularRepository;
import com.interviewsystem.services.CandidateService;
import com.interviewsystem.services.InterviewerService;
import com.interviewsystem.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Component
public class InterviewScheduler {

    @Autowired
    InterviewerSechduleRepository interviewerSlotRepository;

    @Autowired
    CandidateScheduleRepository candidateSlotRepository;

    @Autowired
    SchedularRepository schedularRepository;

    @Autowired
    InterviewerService interviewerService;

    @Autowired
    CandidateService candidateService;

    @Autowired
    NotificationService notificationService;

    @Scheduled(fixedDelay = 2000 * 60)
    public void scheduleInterviews(){

        List<InterviewerSchdule> interviewerData =  interviewerSlotRepository.findByIsScheduledFalse();
        List<CandidateSchdule> candidateData = candidateSlotRepository.findByIsScheduledFalse();

        Map<Date, List<CandidateSchdule>> candidateMap ;
        Map<Date, List<InterviewerSchdule>> interviewerMap;
        //Map<Date, List<InterviewerSlot>> interviewerMap1 = new HashMap<>();
        interviewerMap = interviewerData.stream().collect(groupingBy(i -> i.getDate() , mapping((InterviewerSchdule i) -> i, toList())));
        candidateMap = candidateData.stream().collect(groupingBy(i -> i.getDate() , mapping((CandidateSchdule i) -> i, toList())));

       // interviewerMap1= interviewerData.stream().collect(groupingBy(i -> i.getDate() , mapping((InterviewerSchdule i) ->
      //  new InterviewerSlot(i.getInterviewer(),i.getSlot()), toList())));

        System.out.println("interviewerMap1:" + interviewerMap);

        //interviewerMap= interviewerData.stream().collect(groupingBy(i -> i.getDate() , mapping((InterviewerSchdule i) -> i.getInterviewer(), toList())));
        //candidateMap = candidateData.stream().collect(groupingBy(c -> c.getDate(), mapping((CandidateSchdule c) -> c.getCandidate(), toList())));

        System.out.println("interviewerMap:" + interviewerMap);
        System.out.println("candidateMap:" + candidateMap);

        /*for (Map.Entry<Date, List<Interviewer>> entry : interviewerMap.entrySet()){
            Date date = entry.getKey();
                List<Candidate> candidateList = candidateMap.get(date);
                List<Interviewer> interviewerList = entry.getValue();
                if(candidateList.isEmpty() || interviewerList.isEmpty()){
                    continue;
                }else{
                    for(Interviewer interviewer : interviewerList){
                        String priority = interviewer.getPriority();
                        if(priority.equals("P1")){

                        }
                    }
                }
            }*/

        for (Map.Entry<Date, List<InterviewerSchdule>> entry : interviewerMap.entrySet()){
            Date date = entry.getKey();
            List<CandidateSchdule> candidateList = candidateMap.get(date);
            List<InterviewerSchdule> interviewerSlotList = entry.getValue();
            if(candidateList.isEmpty() || interviewerSlotList.isEmpty()){
                break;
            }else{
                List<CandidateSchdule> candidateWithPriority1 = candidateList.stream().filter( c-> c.getCandidate().getPriority().equals("P1")).collect(toList());
                List<CandidateSchdule> candidateWithPriority2 = candidateList.stream().filter( c-> c.getCandidate().getPriority().equals("P2")).collect(toList());

                for(InterviewerSchdule interviewerSchedule : interviewerSlotList){
                    String priority = interviewerSchedule.getInterviewer().getPriority();
                    String slot = interviewerSchedule.getSlot();
                    if(priority.equals("P1") &&
                            (!(candidateWithPriority1.isEmpty()) ||  !(candidateWithPriority2.isEmpty()))) {

                        interviewerSchedule.setScheduled(true);
                        interviewerSlotRepository.save(interviewerSchedule);
                        CandidateSchdule candidateSchdule;
                        if (!candidateWithPriority1.isEmpty()) {
                            candidateSchdule = candidateWithPriority1.get(0);
                            candidateSchdule.setScheduled(true);
                            candidateSlotRepository.save(candidateSchdule);
                            // remove used data from map and list
                            candidateWithPriority1.remove(candidateSchdule);
                        } else {
                            candidateSchdule = candidateWithPriority2.get(0);
                            candidateSchdule.setScheduled(true);
                            candidateSlotRepository.save(candidateSchdule);
                            // remove used data from map and list
                            candidateWithPriority2.remove(candidateSchdule);
                        }
                        Schedular schedular = new Schedular();
                        schedular.setCid(candidateSchdule.getCandidate());
                        schedular.setIid(interviewerSchedule.getInterviewer());
                        schedular.setSlot(slot);
                        schedular.setScheduledDate(date);
                        schedularRepository.save(schedular);
                    }else if( !candidateWithPriority2.isEmpty()){
                        interviewerSchedule.setScheduled(true);
                        interviewerSlotRepository.save(interviewerSchedule);
                        CandidateSchdule candidateSchdule = candidateWithPriority2.get(0);
                        candidateSchdule.setScheduled(true);
                        candidateSlotRepository.save(candidateSchdule);
                        // remove used data from map and list
                        candidateWithPriority2.remove(candidateSchdule);
                        Schedular schedular = new Schedular();
                        schedular.setCid(candidateSchdule.getCandidate());
                        schedular.setIid(interviewerSchedule.getInterviewer());
                        schedular.setSlot(slot);
                        schedular.setScheduledDate(date);
                        schedularRepository.save(schedular);
                    }
                }

                // send notification to remaining candidates of both priority.
                List<Candidate> candidateListForNotify = new ArrayList<>();
                candidateListForNotify.addAll(candidateWithPriority1.stream().map(cs -> cs.getCandidate()).collect(toList()));
                candidateListForNotify.addAll(candidateWithPriority2.stream().map(cs -> cs.getCandidate()).collect(toList()));
                notificationService.notify(candidateListForNotify);
            }
        }
    }
}
