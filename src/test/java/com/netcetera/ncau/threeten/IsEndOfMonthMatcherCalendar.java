package com.netcetera.ncau.threeten;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

final class IsEndOfMonthMatcherCalendar extends TypeSafeMatcher<String> {

  private static final String ZONE_ID = "CET";
  private static final IsEndOfMonthMatcherCalendar INSTANCE = new IsEndOfMonthMatcherCalendar();
  private static final TimeZone ZONE = TimeZone.getTimeZone(ZONE_ID);

  @Override
  public void describeTo(Description description) {
    description.appendText("is end of month");
  }

  @Override
  protected boolean matchesSafely(String dateString) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
      Date date = dateFormat.parse(dateString + ZONE_ID);
      Calendar calendar = GregorianCalendar.getInstance(ZONE);
      calendar.setTime(date);
      return HaggiChecker.isEndOfMonth(calendar);
    } catch (ParseException e) {
      throw new RuntimeException("could not parse '" + dateString + "'", e);
    }
  }
  
  @Override
  public String toString() {
    return "java.util.Calendar";
  }

  @Factory
  static Matcher<String> isEndOfMonthCalendar() {
    return INSTANCE;
  }

}
