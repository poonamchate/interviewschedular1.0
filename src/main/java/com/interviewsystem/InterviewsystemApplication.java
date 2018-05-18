package com.interviewsystem;

import com.interviewsystem.models.entity.Interviewer;
import com.interviewsystem.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewsystemApplication {

	/*@Autowired
	static InterviewerRepository interviewerRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(InterviewsystemApplication.class, args);

		/*Interviewer intr
		interviewerRepository.save();*/
	}

}
