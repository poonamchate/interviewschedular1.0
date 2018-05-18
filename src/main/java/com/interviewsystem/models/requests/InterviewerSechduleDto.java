package com.interviewsystem.models.requests;

import com.interviewsystem.models.enums.Slots;

import java.util.Date;

public class InterviewerSechduleDto {

    private Date date;
    private int iid;
    private Slots slot;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
    }
}
