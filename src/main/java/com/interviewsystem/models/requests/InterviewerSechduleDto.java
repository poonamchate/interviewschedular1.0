package com.interviewsystem.models.requests;

import com.interviewsystem.models.enums.Slots;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class InterviewerSechduleDto {

    @NotNull
    @NotBlank
    private Date date;

    @NotNull
    @NotBlank
    private int iid;

    @NotNull
    @NotBlank
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
