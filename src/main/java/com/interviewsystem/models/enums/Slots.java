package com.interviewsystem.models.enums;

public enum Slots {

    SLOT1("S1"),
    SLOT2("S2");

    private String slot;
    private Slots(String slot){
        this.slot = slot;
    }

    public String getSlot(){
        return slot;
    }
}
