package com.eventplanner.implementation;

import com.eventplanner.common.Event;
import com.eventplanner.common.Month;

import java.text.SimpleDateFormat;
import java.util.*;

public class MonthWithEvent implements Month {
    Calendar calendar = Calendar.getInstance();
    HashMap<Integer, List<Event>> events = new HashMap<>();

    public MonthWithEvent(List<Event> events, Date date) {
        this.calendar.setTime(date);
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
        int firstDayOfWeek = monthStart.getFirstDayOfWeek();
        // find out when the month ends
        monthStart.getActualMaximum(Calendar.DAY_OF_WEEK);
        monthStart.add(Calendar.MONTH, 1);
        monthStart.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // print the month

        System.out.println(new SimpleDateFormat("\n                                 MMMM - YYYY").format(calendar.getTime()));
        System.out.println("|  Sunday   |   Monday  |   Tuesday | Wednesday | Thursday  |   Friday  |  Saturday |");
        System.out.print('|');
        int i = firstDayOfWeek - 6;
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
            if (j++ % 7 == 0 && i != actualMaximum) {
                System.out.println();
                System.out.print('|');
            }
        }
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


    @Override
    public Calendar getCalendar() {
        return (Calendar) calendar.clone();
    }

}