package com.eventplanner.service;

public interface WabashEvent {
/**
 * Designates which dates are ones that have a Wabash event.
 *
 *  Sets the month's Wabash events.
 */
        void setDates();
/**
 * Queries the User to select an event they are looking for.
 ** @return the date that the event occurs on.
 */
        int inputGetEvent();
/**
 * Returns true if the Event is a Wabash event.
 *
 * @return a Boolean value to represent if the event is a Wabash event.
 */
        boolean isWabashEvent();
        }