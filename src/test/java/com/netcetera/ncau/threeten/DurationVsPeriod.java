package com.netcetera.ncau.threeten;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class DurationVsPeriod {
  
  /**
   * Verifies the different behavior of {@link Duration} and
   * {@link Period}.
   */
  @Test
  public void plusOneDay() {
    ZoneId zurich = ZoneId.of("Europe/Zurich");
    LocalTime time = LocalTime.of(1, 30, 0);
    LocalDate date = LocalDate.of(2014, Month.MARCH, 30);
//    LocalDate date = LocalDate.of(2014, 3, 30);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zurich);
    
    Duration duration = Duration.ofDays(1L);
    Period period = Period.ofDays(1);
    
    assertEquals(2, zonedDateTime.plus(duration).getHour());
    assertEquals(1, zonedDateTime.plus(period).getHour());
  }
  
  
  /**
   * Verifies that {@link ZonedDateTime#plusDays(long)} adds periods
   * and not durations.
   */
  @Test
  public void plusDasy() {
    ZoneId zurich = ZoneId.of("Europe/Zurich");
    LocalTime time = LocalTime.of(1, 30, 0);
    LocalDate date = LocalDate.of(2014, Month.MARCH, 30);
//    LocalDate date = LocalDate.of(2014, 3, 30);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zurich);
    
    Period period = Period.ofDays(1);
    
    assertEquals(zonedDateTime.plus(period), zonedDateTime.plusDays(1L));
  }
  
}
