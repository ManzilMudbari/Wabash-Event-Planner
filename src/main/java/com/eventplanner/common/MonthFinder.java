package com.eventplanner.common;

import java.io.IOException;
import java.util.Calendar;

public interface MonthFinder {
    /**
     * Designates what month should be printed to start.
     * prints the base month.
     */
    void setCurrentMonth(Month currentMonth);

    /**
     * Queries the User to select the desired month.
     *
     */
    Calendar inputDate(Calendar date) throws IOException;
}
