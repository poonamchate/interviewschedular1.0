package com.interviewsystem.models.requests;

import java.util.Date;

public class CandidateScheduleDto {

    private Date date;
    private int cid;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
