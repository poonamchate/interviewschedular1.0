package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

     List<Candidate> findByName(String name);
     List<Candidate> findByExpYears(int experience);
     List<Candidate> findByEmail(String email);
     List<Candidate> findByContact(int contact);
     List<Candidate> findByPriority(String priority);
}
