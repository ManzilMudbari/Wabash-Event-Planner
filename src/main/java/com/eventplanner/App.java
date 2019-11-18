package com.eventplanner;

import com.eventplanner.common.Event;
import com.eventplanner.common.Month;
import com.eventplanner.common.MonthFinder;
import com.eventplanner.implementation.EventManager;
import com.eventplanner.implementation.SimpleMonth;
import com.eventplanner.implementation.SimpleMonthFinder;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException {
        Month m = new SimpleMonth();
        EventManager manager = new EventManager();
        MonthFinder finder = new SimpleMonthFinder();

        finder.setCurrentMonth(m);
        Calendar calendar = finder.inputDate(m.getCalendar());
        Event event = manager.inputNewEvent(calendar);


    }
}
