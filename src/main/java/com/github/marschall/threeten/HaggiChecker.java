package com.github.marschall.threeten;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.util.Calendar.DAY_OF_MONTH;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Implements the "Haggi date challenge" once using {@link Calendar}
 * and once using the java.time API.
 * 
 * <h3>Haggi Date Challenge</h3>
 * The initial discussion about tricks with Java's calendar classes
 * leads me to three other exercises to bring up here:
 * 
 * <ol>
 *  <li>Create a function that returns a boolean whether today (i.e.
 *  the moment in time when the function is called) is the last day of
 *  the month or not. The function might be called within the whole
 *  time interval of a day, i.e. from [midnight...midnight). (I was
 *  asked that recently for a function in Tcl.)</li>
 *  <li>Create a function that returns the current age of a person in
 *  years (integer only) where the birth date of that person is given.
 *  Some additional requirements:
 *    <ul>
 *     <li>The function can be called any time and should always return
 *     the correct age.</li>
 *     <li>The person in question might live anywhere on earth. The
 *     server where the calculation is done is located in Zurich,
 *     Switzerland.</li>
 *   </ul>
 *  </li>
 *  <li>If we would not use Gregorian calendars and
 *  {@link java.util.Date} but {@link javax.startrek.util.Stardate},
 *  would problem no. 2 be simpler to solve in Java? (You might refer
 *  to <a href="http://starchive.cs.umanitoba.ca/?stardates/">http://starchive.cs.umanitoba.ca/?stardates/</a>
 *  and <a href="http://steve.pugh.net/fleet/stardate.html">http://steve.pugh.net/fleet/stardate.html</a>
 *  for definitions and calculations with stardates.)</li>
 * </ol>
 *
 * <h3>Solution</h3>
 * Only the first challenge is implemented. I don't think the second is
 * solvable without knowing the time zone in which the person was born.
 * Stardates look about as messy as the ISO calendar.
 */
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
    // return now.get(ChronoField.DAY_OF_MONTH) == now.range(ChronoField.DAY_OF_MONTH).getMaximum();
  }

  static boolean isEndOfMonth(Calendar calendar) {
    int endOfMonth = calendar.getActualMaximum(DAY_OF_MONTH);
    return calendar.get(DAY_OF_MONTH) == endOfMonth;
  }

}
