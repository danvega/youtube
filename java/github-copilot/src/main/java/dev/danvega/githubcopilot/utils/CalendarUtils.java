package dev.danvega.githubcopilot.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalendarUtils {

    int calculateDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    int getDaysFromDate(LocalDate date) {
        return date.getDayOfMonth();
    }

    int getYearFromDate(LocalDate date) {
        return date.getYear();
    }


}
