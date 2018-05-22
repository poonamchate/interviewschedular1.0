package com.interviewsystem.scheduler;

import com.interviewsystem.models.entity.Interviewer;

public class InterviewerSlot {

    private Interviewer interviewer;
    String slot;

    public InterviewerSlot(Interviewer interviewer, String slot) {
        this.interviewer = interviewer;
        this.slot = slot;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
