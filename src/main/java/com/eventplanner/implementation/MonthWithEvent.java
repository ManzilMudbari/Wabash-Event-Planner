package com.eventplanner.implementation;

import com.eventplanner.common.Event;
import com.eventplanner.common.Month;

import java.text.SimpleDateFormat;
import java.util.*;

public class MonthWithEvent implements Month {
    Calendar calendar;
    HashMap<Integer, List<Event>> events = new HashMap<>();

    public MonthWithEvent(List<Event> events, Calendar calendar) {
        this.calendar = (Calendar) calendar.clone();
        Calendar instance = Calendar.getInstance();
        for (Event event : events) {
            instance.setTime(event.getStartDate());
            int day = instance.get(Calendar.DAY_OF_MONTH);
            if (!this.events.containsKey(day)) {
                this.events.put(day, new ArrayList<Event>());
            }
            this.events.get(day).add(event);
        }
    }

    public void print() {
        // Find out  when the month starts
        Calendar monthStart = (Calendar) calendar.clone();
        monthStart.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = monthStart.get(Calendar.DAY_OF_WEEK);
        // find out when the month ends
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // print the month
        System.out.println(new SimpleDateFormat("\n                                 MMMM - YYYY").format(calendar.getTime()));
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.println("|  Sunday   |   Monday  |   Tuesday | Wednesday | Thursday  |   Friday  |  Saturday |");
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.print('|');
        int i = -firstDayOfWeek + 1;
        int j = 1;
        // print first line which may be empty
        while (i++ < 0) {
            System.out.print(SPACE);
            j++;
        }

        // print rest of the days
        while (i <= actualMaximum) {
            boolean hasUserEvent = false;
            boolean hasWabashEvent = false;
            if (events.containsKey(i)) {
                for (Event event : events.get(i)) {
                    if (event.isUserEvent()) {
                        hasUserEvent = true;
                    } else {
                        hasWabashEvent = true;
                    }
                }
            }
            printDay(i++, hasUserEvent, hasWabashEvent);
            if (j++ % 7 == 0 && i < actualMaximum) {
                System.out.println();
                System.out.print('|');
            }
        }
        j -= 1;
        while (j++ % 7 != 0) {
            System.out.print(SPACE);
        }
        System.out.println();
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.println();
    }

    private void printDay(int day, boolean hasUserEvent, boolean hasWabashEvent) {
        String indicator;
        if (hasUserEvent && hasWabashEvent) {
            indicator = "UW";
        } else if (hasUserEvent) {
            indicator = "U ";
        } else if (hasWabashEvent) {
            indicator = " W";
        } else {
            indicator = "  ";
        }
        if (day < 10) {
            System.out.print("   " + day + " " + indicator + "    |");
        } else {
            System.out.print("   " + day + " " + indicator + "   |");
        }
    }

    public List<Event> getEventForDay(Date day) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(day);
        int intDay = instance.get(Calendar.DAY_OF_MONTH);
        if (events.containsKey(intDay)) {
            return events.get(intDay);
        } else {
            return Collections.emptyList();
        }

    }

    @Override
    public Calendar getCalendar() {
        return (Calendar) calendar.clone();
    }

    public void printEventsForDay(Date date) {
        List<Event> eventForDay = getEventForDay(date);
        System.out.println(new SimpleDateFormat("MMMM d YYYY").format(date) + " ----------");
        if (eventForDay.isEmpty()) {
            System.out.println("  - Wow! such an emptyness -");
        } else {
            for (int i = 0; i < eventForDay.size(); i++) {
                Event event = eventForDay.get(i);
                System.out.print(String.valueOf(i + 1) + ") ");
                System.out.print(event.isUserEvent() ? "User Event   : " : "Wabash Event : ");
                System.out.print(event.getDescription());

                if (event.isAllDay()) {
                    System.out.println();
                } else {
                    System.out.println(" @ " + new SimpleDateFormat("HH:MM").format(calendar.getTime()));
                }
            }
        }

    }
}