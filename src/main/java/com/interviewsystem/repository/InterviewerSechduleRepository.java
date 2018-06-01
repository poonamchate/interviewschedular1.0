package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.entity.InterviewerSchdule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InterviewerSechduleRepository extends JpaRepository<InterviewerSchdule, Integer> {

    List<InterviewerSchdule> findByIsScheduledFalse();
    List<String> findSlotByInterviewerAndDate(Interviewer interviewer, Date date);
    boolean existsByInterviewer(Interviewer interviewer);
    void deleteByInterviewer(Interviewer interviewer);
}
