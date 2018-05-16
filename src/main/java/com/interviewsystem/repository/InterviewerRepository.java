package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepository extends
/*CrudRepository<User, Long>*/ JpaRepository<Interviewer, Integer> {

}
