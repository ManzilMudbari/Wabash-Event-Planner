package com.eventplanner.service;

interface Month {
    /**
     * Designates which days that are being changed in the month.
     *
     * @param newEvent Appends the Month with the new event.
     */
    void setNewDates(EventInput newEvent);
    /**
     * Function that returns how many days are in a month.
     *
     * @return the number of days in a month.
     */
    int outputDays(int selectedMonth);
    /**
     * Designates what the first day of the month is.
     *
     *  sets which day is the start of the month.
     */
    void outputFirstDay();
}