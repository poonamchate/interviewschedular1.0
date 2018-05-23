package com.interviewsystem.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CandidateSchdule {

    @Id
    @GeneratedValue
    private int cid;

    @OneToOne
    private Candidate candidate;

    @Temporal(TemporalType.DATE)
    private Date date;

    private boolean isScheduled;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
