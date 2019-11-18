package com.eventplanner.implementation;

import com.eventplanner.common.Month;
import com.eventplanner.common.MonthFinder;
import com.eventplanner.common.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleMonthFinder implements MonthFinder {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void setCurrentMonth(Month currentMonth) {
        currentMonth.print();
    }

    @Override
    public Calendar inputDate(Calendar calendar) throws IOException {
        System.out.print("\n Please input the date you want to view in format \"MMM dd\"):");
        while (true) {
            try {
                String s = Reader.readLine();
                Date date = new SimpleDateFormat("MMM dd").parse(s);
                Calendar inputCalendar = Calendar.getInstance();
                inputCalendar.setTime(date);
                calendar.set(Calendar.MONTH, inputCalendar.get(Calendar.MONTH));
                calendar.set(Calendar.DAY_OF_MONTH, inputCalendar.get(Calendar.DAY_OF_MONTH));
                return (Calendar) calendar.clone();
            } catch (ParseException e) {
                System.out.println("\n Invalid date format please input date in format \"MMM dd\")");
            }
        }
    }

}
