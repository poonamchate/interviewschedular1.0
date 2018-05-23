package com.interviewsystem.services;

import com.interviewsystem.models.entity.Candidate;

import java.util.List;


public interface NotificationService {

    void notify(List<Candidate> candidateList);
}
