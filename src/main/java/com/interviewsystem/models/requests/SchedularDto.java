package com.interviewsystem.models.requests;

import com.interviewsystem.models.entity.Candidate;
import com.interviewsystem.models.entity.Interviewer;

import java.util.Date;

public class SchedularDto {

    private int sid;
    private Date scheduledDate;
    private String slot;
    private Candidate candidate;
    private Interviewer interviewer;

    public SchedularDto(Date scheduledDate, String slot, Candidate candidate, Interviewer interviewer) {
        this.scheduledDate = scheduledDate;
        this.slot = slot;
        this.candidate = candidate;
        this.interviewer = interviewer;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }
}
