package com.github.marschall.threeten;

import static com.github.marschall.threeten.IsEndOfMonthMatcher310.isEndOfMonth310;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HaggiCheckerTest {

  @Test
  public void testIsEndOfMonth310() {
    // 2011-01-15 is not end of month
    assertThat("2011-01-15T00:00:00", not(isEndOfMonth310()));
    assertThat("2011-01-15T23:59:59", not(isEndOfMonth310()));
    // 2011-01-30 is not end of month
    assertThat("2011-01-30T00:00:00", not(isEndOfMonth310()));
    assertThat("2011-01-30T23:59:59", not(isEndOfMonth310()));
    // 2011-01-31 is end of month
    assertThat("2011-01-31T00:00:00", isEndOfMonth310());
    assertThat("2011-01-31T23:59:59", isEndOfMonth310());
    
    // 2011-02-27 is not end of month
    assertThat("2011-02-27T00:00:00", not(isEndOfMonth310()));
    assertThat("2011-02-27T23:59:59", not(isEndOfMonth310()));
    // 2011-02-28 is end of month
    assertThat("2011-02-28T00:00:00", isEndOfMonth310());
    assertThat("2011-02-28T23:59:59", isEndOfMonth310());
    
    // 2011-02-27 is not end of month
    assertThat("2012-02-27T00:00:00", not(isEndOfMonth310()));
    assertThat("2012-02-27T23:59:59", not(isEndOfMonth310()));
    // 2011-02-28 is end of month
    assertThat("2012-02-28T00:00:00", not(isEndOfMonth310()));
    assertThat("2012-02-28T23:59:59", not(isEndOfMonth310()));
    // 2011-02-29 is end of month
    assertThat("2012-02-29T00:00:00", isEndOfMonth310());
    assertThat("2012-02-29T23:59:59", isEndOfMonth310());
  }

}
