package com.eventplanner;

import com.eventplanner.common.Event;
import com.eventplanner.common.Month;
import com.eventplanner.common.MonthFinder;
import com.eventplanner.implementation.EventManager;
import com.eventplanner.implementation.MonthWithEvent;
import com.eventplanner.implementation.SimpleMonth;
import com.eventplanner.implementation.SimpleMonthFinder;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException {
        Date today = new Date();
        EventManager manager = new EventManager();
        MonthFinder finder = new SimpleMonthFinder();
        List<Event> eventForMonth = manager.getEventForMonth(today);
        Month m = new MonthWithEvent(eventForMonth, today);
        manager.getEvent(m.getCalendar().getTime());
        finder.setCurrentMonth(m);
        Calendar calendar = finder.inputDate(m.getCalendar());
        Event event = manager.inputNewEvent(calendar);


    }
}
