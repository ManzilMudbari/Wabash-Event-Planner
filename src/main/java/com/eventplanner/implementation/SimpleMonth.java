package com.eventplanner.implementation;

import com.eventplanner.common.Month;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleMonth implements Month {
    private static String SPACE = "           |";
    private Calendar calendar = Calendar.getInstance();

    public SimpleMonth() {
        calendar.setTimeInMillis(System.currentTimeMillis());
    }

    public SimpleMonth(Date date) {
        calendar.setTime(date);
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
        while (i < actualMaximum) {
            printDay(i++);
            if (j++ % 7 == 0) {
                System.out.println();
                System.out.print('|');
            }
        }
        printDay(i);
        System.out.println();
    }

    private void printDay(int day) {
        if (day < 10) {
            System.out.print("     " + day + "     |");
        } else {
            System.out.print("     " + day + "    |");
        }
    }


    @Override
    public Calendar getCalendar() {
        return (Calendar) calendar.clone();
    }
}
