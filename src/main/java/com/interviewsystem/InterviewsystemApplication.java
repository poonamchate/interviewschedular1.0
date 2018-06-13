package com.interviewsystem;

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
