package com.eventplanner.implementation;

import com.eventplanner.common.Event;

import java.util.Date;

public class SimpleEvent implements Event {
    boolean allDay;
    boolean userEvent;
    Date startDate;
    Date endDate;
    String description;

    public SimpleEvent(Date startDate, Date endDate, boolean isUserEvent, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.userEvent = isUserEvent;
        this.description = description;
        this.allDay = false;
    }

    public SimpleEvent(Date startDate, boolean isUserEvent, String description) {
        this.startDate = startDate;
        this.userEvent = isUserEvent;
        this.description = description;
        this.allDay = true;

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
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
