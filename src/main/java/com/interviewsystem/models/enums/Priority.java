package com.interviewsystem.models.enums;

public enum Priority {

    PRIORITY1("P1"),
    PRIORITY2("P2");

    private String value;

    private Priority(String value){
        this.value = value;
    }

    public String getPriority(){
        return value;
    }

}
