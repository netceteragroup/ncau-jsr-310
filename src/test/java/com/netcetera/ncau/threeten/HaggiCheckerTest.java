package com.netcetera.ncau.threeten;

import static com.netcetera.ncau.threeten.IsEndOfMonthMatcher310.isEndOfMonth310;
import static com.netcetera.ncau.threeten.IsEndOfMonthMatcherCalendar.isEndOfMonthCalendar;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HaggiCheckerTest {
  
  private final Matcher<String> isEndOfMonth;

  public HaggiCheckerTest(Matcher<String> isEndOfMonth) {
    this.isEndOfMonth = isEndOfMonth;
  }
  
  @Parameters(name = "{0}")
  public static Collection<Object[]> matchers() {
    return Arrays.asList(new Object[]{isEndOfMonth310()}, new Object[]{isEndOfMonthCalendar()});
  }

  @Test
  public void testIsEndOfMonth() {
    // 2011-01-15 is not end of month
    assertThat("2011-01-15T00:00:00", not(isEndOfMonth));
    assertThat("2011-01-15T23:59:59", not(isEndOfMonth));
    // 2011-01-30 is not end of month
    assertThat("2011-01-30T00:00:00", not(isEndOfMonth));
    assertThat("2011-01-30T23:59:59", not(isEndOfMonth));
    // 2011-01-31 is end of month
    assertThat("2011-01-31T00:00:00", isEndOfMonth);
    assertThat("2011-01-31T23:59:59", isEndOfMonth);
    
    // 2011-02-27 is not end of month
    assertThat("2011-02-27T00:00:00", not(isEndOfMonth));
    assertThat("2011-02-27T23:59:59", not(isEndOfMonth));
    // 2011-02-28 is end of month
    assertThat("2011-02-28T00:00:00", isEndOfMonth);
    assertThat("2011-02-28T23:59:59", isEndOfMonth);
    
    // 2011-02-27 is not end of month
    assertThat("2012-02-27T00:00:00", not(isEndOfMonth));
    assertThat("2012-02-27T23:59:59", not(isEndOfMonth));
    // 2011-02-28 is end of month
    assertThat("2012-02-28T00:00:00", not(isEndOfMonth));
    assertThat("2012-02-28T23:59:59", not(isEndOfMonth));
    // 2011-02-29 is end of month
    assertThat("2012-02-29T00:00:00", isEndOfMonth);
    assertThat("2012-02-29T23:59:59", isEndOfMonth);
  }

}
