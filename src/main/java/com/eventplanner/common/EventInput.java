package com.eventplanner.common;

import java.util.Date;
import java.util.List;

public interface EventInput {
    /**
     * Designates that a given date has no user events.
     * Displays nothing if no user event is found.
     */
    void setEmpty();

    /**
     * Queries the user to add a new event to the month.
     * Takes in the Event detail that are to be appended.
     */
    Event inputNewEvent();

    List<Event> getEvent(Date date);
}
