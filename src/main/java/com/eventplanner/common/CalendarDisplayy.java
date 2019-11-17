package com.eventplanner.common;

public interface CalendarDisplayy {
    /**
     * Designates what month should be printed to start.
     * prints the base month.
     */
    void setCurrentMonth(MonthFinder currentMonth);

    /**
     * Displays the new month the the user has inputted.
     * prints the new desired month.
     */
    void inputNewMonth(MonthFinder userMonth);

    /**
     * Displays the user's selected date.
     * prints the user's selected day of the month.
     */
    void inputSeeDay(MonthFinder userMonth, int userDay);
}
