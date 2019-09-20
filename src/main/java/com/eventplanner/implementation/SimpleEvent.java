package com.eventplanner.implementation;

import com.eventplanner.common.Event;

import java.util.Date;

public class SimpleEvent implements Event {
    boolean allDay;
    boolean userEvent;
    Date date;
    String description;


    public SimpleEvent(Date date, boolean allDay, boolean isUserEvent, String description) {
        this.date = date;
        this.userEvent = isUserEvent;
        this.description = description;
        this.allDay = allDay;
    }

    @Override
    public boolean isAllDay() {
        return allDay;
    }

    @Override
    public boolean isUserEvent() {
        return userEvent;
    }

    @Override
    public Date getStartDate() {
        return date;
    }

    @Override
    public Date getEndDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
