package com.github.marschall.threeten;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

final class IsEndOfMonthMatcherCalendar extends TypeSafeMatcher<String> {

  private static final IsEndOfMonthMatcher310 INSTANCE = new IsEndOfMonthMatcher310();

  @Override
  public void describeTo(Description description) {
    description.appendText("is end of month");
  }

  @Override
  protected boolean matchesSafely(String dateString) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
      Date date = dateFormat.parse(dateString + "+0100");
      Calendar calendar = GregorianCalendar.getInstance();
      calendar.setTime(date);
      return HaggiChecker.isEndOfMonth(calendar);
    } catch (ParseException e) {
      throw new RuntimeException("could not parse '" + dateString + "'", e);
    }
  }

  @Factory
  static Matcher<String> isEndOfMonthCalendar() {
    return INSTANCE;
  }

}
