package com.interviewsystem;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InterviewsystemApplication {

	/*@Autowired
	static InterviewerRepository interviewerRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(InterviewsystemApplication.class, args);

		/*Interviewer intr
		interviewerRepository.save();*/
	}

}
