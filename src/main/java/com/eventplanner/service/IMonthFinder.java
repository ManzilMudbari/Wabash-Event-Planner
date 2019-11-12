package com.eventplanner.service;

public interface IMonthFinder {
    /**
     * Designates what month the program displays first.
     *
     * @param baseIMonth user sees starting month
     */
    void setCurrentMonth(IMonth baseIMonth);
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
