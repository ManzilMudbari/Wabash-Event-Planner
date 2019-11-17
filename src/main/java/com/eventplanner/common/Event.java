package com.eventplanner.common;

import java.util.Date;

public interface Event {
    boolean isAllDay();

    boolean isUserEvent();

    Date getStartDate();

    Date getEndDate();

    String getDescription();
}
