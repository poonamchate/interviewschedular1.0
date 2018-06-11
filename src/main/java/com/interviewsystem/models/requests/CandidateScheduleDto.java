package com.interviewsystem.models.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CandidateScheduleDto {

    @NotBlank
    @NotNull
    private Date date;

    @NotBlank
    @NotNull
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
