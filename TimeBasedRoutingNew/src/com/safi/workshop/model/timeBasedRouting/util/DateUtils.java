package com.safi.workshop.model.timeBasedRouting.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.time.FastDateFormat;

public class DateUtils {
  /**
   * All minutes have this many milliseconds except the last minute of the day on a day
   * defined with a leap second.
   */
  public static final long MILLISECS_PER_MINUTE = 60 * 1000;

  /**
   * Number of milliseconds per hour, except when a leap second is inserted.
   */
  public static final long MILLISECS_PER_HOUR = 60 * MILLISECS_PER_MINUTE;

  /**
   * Number of leap seconds per day expect on <BR/>
   * 1. days when a leap second has been inserted, e.g. 1999 JAN 1. <BR/>
   * 2. Daylight-savings "spring forward" or "fall back" days.
   */
  protected static final long MILLISECS_PER_DAY = 24 * MILLISECS_PER_HOUR;

//  private final static DateFormat SHORT_FORMAT = SimpleDateFormat.getDateTimeInstance(
//      SimpleDateFormat.SHORT, SimpleDateFormat.SHORT);

  public static final FastDateFormat DATE_INSTANCE = FastDateFormat
      .getDateInstance(SimpleDateFormat.SHORT);

  public static String numToNth(int num) {
    int ones = num % 10;
    int tens = num % 100;
    String suffix = null;
    switch (ones) {
      case 1:
        if (tens == 11)
          suffix = "th";
        else
          suffix = "st";
        break;
      case 2:
        if (tens == 12)
          suffix = "th";
        else
          suffix = "nd";
        break;
      case 3:
        if (tens == 13)
          suffix = "th";
        else
          suffix = "rd";
        break;
      default:
        suffix = "th";
    }
    return num + suffix;
  }

  public static long daysBetween(Calendar startDate, Calendar endDate) {
    // if (startDate.before(endDate)){
    // Calendar temp = startDate;
    // startDate = endDate;
    // endDate = temp;
    // }
    // Calendar date = (Calendar) startDate.clone();
    long daysBetween = diff24HourPeriods(startDate, endDate);
    Calendar date = startDate;
    date.add(Calendar.DAY_OF_MONTH, (int) daysBetween);

    if (date.after(endDate)) {
      while (date.after(endDate)) {
        date.add(Calendar.DAY_OF_MONTH, -1);
        daysBetween--;
      }
    } else if (date.before(endDate)) {
      while (date.before(endDate)) {
        date.add(Calendar.DAY_OF_MONTH, 1);
        daysBetween++;
      }
    }
    return daysBetween;
  }

  public static long weeksBetween(Calendar startDate, Calendar endDate) {

    long daysBetween = daysBetween(startDate, endDate);
    return daysBetween / 7;
  }

  public static long diff24HourPeriods(Calendar start, Calendar end) {
    long endL = end.getTimeInMillis();
    long startL = start.getTimeInMillis();
    return (endL - startL) / MILLISECS_PER_DAY;
  }

  public static void main(String[] args) {
    Calendar start = Calendar.getInstance();
    start.set(Calendar.HOUR_OF_DAY, 0);
    start.set(Calendar.MINUTE, 0);
    start.set(Calendar.MILLISECOND, 0);
    Calendar end = (Calendar) start.clone();
    start.add(Calendar.DAY_OF_YEAR, -2);
    start.add(Calendar.YEAR, -1);
    long daysBetween = daysBetween(start, end);
  }

  public static int monthsBetween(Calendar start, Calendar now) {
    int endMonths = now.get(Calendar.YEAR)*12 + now.get(Calendar.MONTH);
    int startMonths = start.get(Calendar.YEAR)*12 + start.get(Calendar.MONTH);
    return endMonths - startMonths;
  }
  
  public static Calendar zeroOutTime(Calendar time){
    time.set(Calendar.HOUR_OF_DAY, 0);
    time.set(Calendar.MINUTE, 0);
    time.set(Calendar.SECOND, 0);
    time.set(Calendar.MILLISECOND, 0);
    return time;
  }
}
