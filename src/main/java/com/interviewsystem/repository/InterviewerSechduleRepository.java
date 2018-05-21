package com.interviewsystem.repository;

import com.interviewsystem.models.entity.InterviewerSchdule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerSechduleRepository extends JpaRepository<InterviewerSchdule, Integer> {

    List<InterviewerSchdule> findByIsScheduledFalse();
}
