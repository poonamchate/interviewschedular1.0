package com.interviewsystem.repository;

import com.interviewsystem.models.entity.Schedular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedularRepository extends JpaRepository<Schedular, Integer> {

}
