package com.eventplanner.implementation;

import com.eventplanner.common.Event;
import com.eventplanner.common.EventInput;
import com.eventplanner.common.Reader;

import java.io.*;
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
        File file = new File(yearDir, String.valueOf(month) + ".txt");
        BufferedWriter fileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        fileOutputStream.write(event.getStartDate().toString());
        fileOutputStream.newLine();
        fileOutputStream.write(event.isAllDay() ? "y" : "n");
        fileOutputStream.newLine();
        fileOutputStream.write(event.getDescription());
        fileOutputStream.newLine();
        fileOutputStream.close();

    }

    @Override
    public Event inputNewEvent(Calendar calendar) throws IOException {
        System.out.print("Enter the Event Description :");
        String description = Reader.readLine();
        System.out.print("Is this an All-Day Event (Y or N)?");
        boolean allDay = Reader.readLine().startsWith("Y");
        do {
            try {
                System.out.print("What time does this Occur at (Format HH:MM)?");
                String s = Reader.readLine();
                String[] split = s.split(":");
                int hour = Integer.parseInt(split[0]);
                int mins = Integer.parseInt(split[1]);

                calendar.set(Calendar.MINUTE, mins);
                calendar.set(Calendar.HOUR, hour);

                SimpleEvent simpleEvent = new SimpleEvent(calendar.getTime(), true, description);
                saveEvent(simpleEvent);
                return simpleEvent;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid time input please use format \"HH:MM\" :");
            }
        } while (true);

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
        File file = new File(new File(homeDirectory, String.valueOf(year)), String.valueOf(month));
        List<Event> list = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                Date startDate = new Date(Date.parse(bufferedReader.readLine()));
                boolean allDay = bufferedReader.readLine().equals("y");
                String description = bufferedReader.readLine();
                list.add(new SimpleEvent(startDate, allDay, description));
            } catch (EOFException ignore) {
            }
            return list;

        } else {
            return Collections.emptyList();
        }
    }

}
