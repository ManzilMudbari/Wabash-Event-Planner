package com.eventplanner.service;

import java.util.Scanner;

public class CalenderSystem implements IMonthFinder {

    // months[i] = name of month i
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
    public void setCurrentMonth(IMonth baseIMonth) {
    }

    @Override
    public int inputCurrentMonth() {
        System.out.println("Enter current month(1-12)");
        Scanner scanner = new Scanner(System.in);
        String currentMonth = scanner.nextLine();
        System.out.println("Your current is " + currentMonth);
        return Integer.parseInt(currentMonth);
    }

    @Override
    public int inputCurrentDay() {
        return 0;
    }
}
