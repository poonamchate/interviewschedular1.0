package com.interviewsystem.models.requests;

import javax.validation.constraints.*;

public class CandidateDto {

    private int cid;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String name;

    @NotNull(message = "Experience years should not be null")
    @NotBlank(message = "Experience years should not be null")
    private int expYears;

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

    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpYears() {
        return expYears;
    }

    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public Date getToDate() {
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
