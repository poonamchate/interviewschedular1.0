package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.models.entity.Schedular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedularRepository extends JpaRepository<Schedular, Integer> {

    boolean existsByCid(Candidate candidate);
    void deleteByCid(Candidate candidate);

    boolean existsByIid(Interviewer interviewer);
    void deleteByIid(Interviewer interviewer);
}
