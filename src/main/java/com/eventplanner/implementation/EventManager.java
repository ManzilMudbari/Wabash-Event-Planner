package com.eventplanner.implementation;

import com.eventplanner.common.Event;
import com.eventplanner.common.EventInput;
import com.eventplanner.common.Reader;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class EventManager implements EventInput {
    private File homeDirectory = new File(System.getProperty("user.home"));

    public EventManager() {
        homeDirectory = new File(homeDirectory, ".calendarApp");
        if (!homeDirectory.exists()) {
            boolean mkdirs = homeDirectory.mkdirs();
            if (!mkdirs) {
                System.err.println("Cannot access folder :" + homeDirectory.getAbsolutePath());
                System.exit(1);
            }
        }

    }

    @Override
    public void setEmpty() {

    }

    private void saveEvent(Event event) throws IOException {
        Calendar instance = Calendar.getInstance();
        instance.setTime(event.getStartDate());
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        File yearDir = new File(homeDirectory, String.valueOf(year));
        if (!yearDir.exists()) {
            yearDir.mkdirs();
        }

        try (BufferedWriter fileOutputStream = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File(yearDir, String.valueOf(month) + ".txt"), true)))) {
            fileOutputStream.write(String.valueOf(event.getStartDate().getTime()));
            fileOutputStream.newLine();
            fileOutputStream.write(event.isAllDay() ? "y" : "n");
            fileOutputStream.newLine();
            fileOutputStream.write(event.isUserEvent() ? "u" : "w");
            fileOutputStream.newLine();
            fileOutputStream.write(event.getDescription());
            fileOutputStream.newLine();
        }
    }

    @Override
    public boolean inputNewEvent(Calendar calendar) throws IOException {
        System.out.println();
        if (!getEntryConfirmation(calendar)) {
            return false;
        }
        System.out.print("Enter the Event Description :");
        String description = Reader.readLine();
        System.out.print("Is this an All-Day Event (Y or N)?");
        boolean allDay = Reader.readLine().startsWith("Y");
        if (!allDay) {
            do {
                try {
                    System.out.print("What time does this Occur at (Format HH:MM)?");
                    String s = Reader.readLine();
                    String[] split = s.split(":");
                    int hour = Integer.parseInt(split[0].replaceAll("\\s+", ""));
                    int mins = Integer.parseInt(split[1].replaceAll("\\s+", ""));
                    calendar.set(Calendar.MINUTE, mins);
                    calendar.set(Calendar.HOUR, hour);
                    break;
                } catch (NumberFormatException ex) {
                    System.out.print("Invalid time input please use format \"HH:MM\" :");
                }
            } while (true);
        }
        SimpleEvent simpleEvent = new SimpleEvent(calendar.getTime(), allDay, true, description);
        saveEvent(simpleEvent);
        return true;

    }

    @Override
    public List<Event> getEvent(Date date) throws IOException {
        return null;
    }


    public List<Event> getEventForMonth(Date date) throws IOException {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        File file = new File(new File(homeDirectory, String.valueOf(year)), String.valueOf(month) + ".txt");
        List<Event> list = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String dateValue = readLine.replaceAll("\\s+", "");
                    Date startDate = new Date(Long.valueOf(dateValue));
                    boolean allDay = bufferedReader.readLine().replaceAll("\\s+", "").equals("y");
                    boolean userEvent = bufferedReader.readLine().replaceAll("\\s+", "").equals("u");
                    String description = bufferedReader.readLine();
                    list.add(new SimpleEvent(startDate, allDay, userEvent, description));
                }
            } catch (EOFException ignore) {
            }
            return list;

        } else {
            return Collections.emptyList();
        }
    }


    public boolean getEntryConfirmation(Calendar inputCalendar) throws IOException {
        while (true) {
            System.out.print("Do you want to add a new event on " + new SimpleDateFormat("MMMM d YYYY").format(inputCalendar.getTime()) + "? (Y/N/Q) :");
            String s = Reader.readLine().toLowerCase();
            if (s.equals("q")) {
                System.out.println("Good Bye!!");
                System.exit(0);
            } else if (s.equals("y")) {
                return true;
            } else if (s.equals("n")) {
                return false;
            }
        }
    }

}
