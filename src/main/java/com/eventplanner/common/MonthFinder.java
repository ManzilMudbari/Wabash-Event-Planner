package com.eventplanner.common;

public interface MonthFinder {
    /**
     * Designates what month should be printed to start.
     * prints the base month.
     */
    void setCurrentMonth(Month currentMonth);

    /**
     * Queries the User to select the desired month.
     *
     * @return the number of the desired month.
     */
    int inputCurrentMonth();

    /**
     * Queries the User to pick which day they want to see
     *
     * @return the User's disired day to be displayed.
     */
    int inputCurrentDay();
}
