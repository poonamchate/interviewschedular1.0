package com.interviewsystem.models.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
public class InterviewerSchdule {

    @Id
    @GeneratedValue
    private int iid;

    @OneToOne
    private Interviewer interviewer;

    private Date date;

    private String slot;

    private boolean isScheduled;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }
}
