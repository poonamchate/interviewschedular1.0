package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerRepository extends JpaRepository<Interviewer, Integer> {

    List<Interviewer> findByName(String name);
    List<Interviewer> findByEmail(String email);
    List<Interviewer> findByContact(int contact);
    List<Interviewer> findByPriority(String priority);
}
