package com.eventplanner.service;

public interface MonthFinder {
    /**
     * Designates what month the program displays first.
     *
     * @param baseMonth user sees starting month
     */
    void setCurrentMonth(Month baseMonth);
    /**
     * Queries the User to select the desired month.
     *
     * @return the number of the desired month.
     */int inputCurrentMonth();
    /**
     * Queries the User to pick which day they want to see
     *
     * @return the User's disired day to be displayed.
     */
    int inputCurrentDay();
}
