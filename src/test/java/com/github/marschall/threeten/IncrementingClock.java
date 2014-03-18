package com.github.marschall.threeten;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A {@link Clock} that increments it's value by a second every time
 * it's accessed.
 */
class IncrementingClock extends Clock {
  
//  static final long START = 1395159294605L;
  static final long START = 1395159294L;
  
  private final ZoneId zone;
  
  private final AtomicLong epochSecond;

  IncrementingClock(ZoneId zone) {
    this(zone, START);
  }
  
  private IncrementingClock(ZoneId zone, long epochSecond) {
    this.zone = zone;
    this.epochSecond = new AtomicLong(epochSecond);
  }

  @Override
  public ZoneId getZone() {
    return this.zone;
  }

  @Override
  public Clock withZone(ZoneId zone) {
    if (this.zone.equals(zone)) {
      return this;
    } else {
      return new IncrementingClock(zone, this.epochSecond.get());
    }
  }

  @Override
  public Instant instant() {
    return Instant.ofEpochSecond(this.epochSecond.getAndIncrement());
  }
  
  public static void main(String[] args) {
    System.out.println(System.currentTimeMillis());
  }

}
