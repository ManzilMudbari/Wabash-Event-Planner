package com.eventplanner.implementation;

import com.eventplanner.common.Event;
import com.eventplanner.common.EventInput;

import java.util.Date;
import java.util.List;

public class EventManager implements EventInput {
    @Override
    public void setEmpty() {

    }

    @Override
    public Event inputNewEvent() {
        return null;
    }

    @Override
    public List<Event> getEvent(Date date) {
        return null;
    }

}
