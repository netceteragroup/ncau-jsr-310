package com.github.marschall.threeten;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.util.Calendar.DAY_OF_MONTH;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HaggiChecker {

  public static boolean isEndOfMonth310() {
    return isEndOfMonth(ZonedDateTime.now());
  }
  
  public static boolean isEndOfMonthCalendar() {
    return isEndOfMonth(GregorianCalendar.getInstance());
  }

  static boolean isEndOfMonth(ZonedDateTime now) {
    ZonedDateTime lastDayOfMonth = now.with(lastDayOfMonth());
    return now.getDayOfMonth() == lastDayOfMonth.getDayOfMonth();
  }
  
  static boolean isEndOfMonth(Calendar calendar) {
    int endOfMonth = calendar.getActualMaximum(DAY_OF_MONTH);
    return calendar.get(DAY_OF_MONTH) == endOfMonth;
  }


}
