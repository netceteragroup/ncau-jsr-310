package com.github.marschall.threeten;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.NetworkInterface;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Enumeration;

import org.junit.Test;

public class DurationVsPeriod {
  
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
  
  @Test
//  @Ignore
  public void theJavaBot() throws IOException {
    for (Object each : System.getProperties().entrySet()) {
      System.out.println(each);
    }
    
    System.out.println(java.nio.file.Paths.get("").toAbsolutePath());
    System.out.println(java.nio.file.Files.isReadable(java.nio.file.Paths.get("/etc/passwd")));
    System.out.println(MethodHandles.lookup().lookupClass());
    for (Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces(); e.hasMoreElements();) {
      System.out.println(e.nextElement().getInterfaceAddresses().get(1));
    }
    
    System.out.println(System.getProperty("java.runtime.version"));
    System.out.println(System.getProperty("os.name"));
    System.out.println(this);
    System.out.println(this.getClass());
    System.out.println(this.getClass().getClassLoader());
    
    System.out.println(Runtime.getRuntime().maxMemory());
    System.out.println(java.net.InetAddress.getLocalHost().getHostName());
    System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());
    System.out.println(new java.net.ServerSocket(0).getInetAddress().getCanonicalHostName());
  }

}
