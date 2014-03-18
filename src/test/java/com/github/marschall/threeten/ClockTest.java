package com.github.marschall.threeten;

import static org.junit.Assert.assertEquals;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Before;
import org.junit.Test;

/**
 * Demonstrates how to use a custom {@link Clock}.
 */
public class ClockTest {
  
  private Clock clock;

  @Before
  public void setUp() {
    ZoneId zone = ZoneId.of("Europe/Zurich");
    this.clock = new IncrementingClock(zone);
  }
  
  /**
   * Demonstrates how {@link LocalDateTime} can be used with a custom
   * {@link Clock}.
   */
  @Test
  public void dateTimeNow() {
    LocalDateTime earlier = LocalDateTime.now(clock);
    LocalDateTime later = LocalDateTime.now(clock);
    
    assertEquals(later, earlier.plusSeconds(1L));
    
    Duration oneSecond = Duration.ofSeconds(1L);
    assertEquals(oneSecond, Duration.between(earlier, later));
    
    assertEquals(earlier, LocalDateTime.of(2014, 3, 18, 17, 14, 54));
    assertEquals(later, LocalDateTime.of(2014, 3, 18, 17, 14, 55));
  }

}
