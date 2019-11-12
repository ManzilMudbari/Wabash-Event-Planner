package com.eventplanner.service;

public class MonthImpl implements IMonth {

    String[] months = {
            "",                               // leave empty so that months[1] = "January"
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
    };

    // days[i] = number of days in month i
    int[] days = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    @Override
    public void setNewDates(IEventInput newEvent) {

    }

    @Override
    public int outputDays(int selectedMonth) {
        return 0;
    }

    @Override
    public void outputFirstDay() {

    }
}
