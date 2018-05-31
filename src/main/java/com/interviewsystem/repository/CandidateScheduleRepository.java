package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.CandidateSchdule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateScheduleRepository extends JpaRepository<CandidateSchdule, Integer> {

    List<CandidateSchdule> findByIsScheduledFalse();
    void deleteByCandidate(Candidate candidate);
    boolean existsByCandidate(Candidate candidate);
}
