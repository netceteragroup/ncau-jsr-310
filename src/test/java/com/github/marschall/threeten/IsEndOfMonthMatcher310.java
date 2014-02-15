package com.github.marschall.threeten;

import java.time.ZonedDateTime;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

final class IsEndOfMonthMatcher310 extends TypeSafeMatcher<String> {

  private static final IsEndOfMonthMatcher310 INSTANCE = new IsEndOfMonthMatcher310();

  @Override
  public void describeTo(Description description) {
    description.appendText("is end of month");
  }

  @Override
  protected boolean matchesSafely(String dateString) {
    ZonedDateTime dateTime = ZonedDateTime.parse(dateString + "+01:00[Europe/Paris]");
    return HaggiChecker.isEndOfMonth(dateTime);
  }

  @Factory
  static Matcher<String> isEndOfMonth310() {
    return INSTANCE;
  }

}
