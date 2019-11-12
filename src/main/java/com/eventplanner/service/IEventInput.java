package com.eventplanner.service;

public interface IEventInput {
    /**
     * Designates that a given date has no user events.
     *
     * Displays nothing if no user event is found.
     */
    void setEmpty();
    /**
     * Queries the user to add a new event to the month.
     *
     * Takes in the Event detail that are to be appended.
     */
    void inputNewEvent();
    /**
     * Returns true if the Event is a User event.
     *
     * @return a Boolean value to represent if the event is a User event.
     */
    boolean isUserEvent();
}
