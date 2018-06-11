package com.interviewsystem.models.requests;

import com.interviewsystem.models.enums.Priority;

import javax.validation.constraints.*;

public class InterviewerDto {

    private int iid;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String iName;

    @NotNull
    @NotBlank
    @Email
    private String email;
    /*private Date toDate;
    private Date fromDate;*/

    @NotNull
    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String contact;

    @NotNull
    @NotBlank
    private Priority priority;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }*/

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
