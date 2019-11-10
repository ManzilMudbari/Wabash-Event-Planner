package com.eventplanner.service;

public interface CalendarDisplay   {
    /**
     * Designates what month should be printed to start.
     *
     * @param currentMonth prints the base month.
     */
    void setCurrentMonth(MonthFinder currentMonth);
    /**
     * Displays the new month the the user has inputted.
     *
     * @param userMonth prints the new desired month.
     */
    void inputNewMonth(MonthFinder userMonth);/**
     * Displays the user's selected date.
     *
     * @param userMonth,userDay the user's selected day of the month.
     */
    void inputSeeDay(MonthFinder userMonth,int userDay);
}
