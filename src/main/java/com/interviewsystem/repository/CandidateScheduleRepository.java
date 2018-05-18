package com.interviewsystem.repository;

import com.interviewsystem.models.entity.CandidateSchdule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateScheduleRepository extends JpaRepository<CandidateSchdule, Integer> {

}
