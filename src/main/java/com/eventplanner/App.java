package com.eventplanner;

import com.eventplanner.common.Event;
import com.eventplanner.common.MonthFinder;
import com.eventplanner.implementation.EventManager;
import com.eventplanner.implementation.MonthWithEvent;
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
    public static void printMonthAndEvents(Calendar calendar, EventManager manager, MonthFinder finder) throws IOException {
        List<Event> eventForMonth = manager.getEventForMonth(calendar.getTime());
        MonthWithEvent m = new MonthWithEvent(eventForMonth, calendar);
        finder.setCurrentMonth(m);
        m.printEventsForDay(calendar.getTime());
    }
    public static void main(String[] args) throws IOException {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(new Date());
        EventManager manager = new EventManager();
        MonthFinder finder = new SimpleMonthFinder();
        do {
            printMonthAndEvents(currentCalendar, manager, finder);
            Calendar inputCalendar = (Calendar) currentCalendar.clone();
            // while user is adding new events, do nothing else
            while (manager.inputNewEvent(currentCalendar)) {
            }
            inputCalendar = finder.inputDate(currentCalendar);
            currentCalendar.set(Calendar.MONTH, inputCalendar.get(Calendar.MONTH));
            currentCalendar.set(Calendar.DAY_OF_MONTH, inputCalendar.get(Calendar.DAY_OF_MONTH));
        } while (true);

    }
}
