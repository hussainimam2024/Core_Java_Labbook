package org.example.Basicjava;

import net.bytebuddy.asm.Advice;

import java.sql.SQLOutput;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Dateclass {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(instant);

        LocalDate now= LocalDate.now();

        System.out.println("todays date withot formatter:"+now);
        System.out.println("Todays date with formatter:"+now.format(formatter));

        System.out.println(now.getDayOfMonth());
        System.out.println("Tomorrow"+ now.plusDays(1));
        System.out.println("yesterday"+ now.minusDays(1));
        System.out.println("last momth:"+now.minusMonths(1));
        System.out.println("leap year:"+now.isLeapYear());
        System.out.println("move to 30th day of month"+now.withDayOfMonth(30));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Indian time in asia zone:"+zonedDateTime);

        ZonedDateTime current_paris = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("Current time in paris: "+current_paris);

        ZonedDateTime curr_aus = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println("Current time in Australia: "+curr_aus);

        LocalDate start = LocalDate.of(1947, Month.AUGUST,15);
        LocalDate end = LocalDate.now();
        Period period = Period.between(start, end);

        System.out.println("Number of years of Independence:"+period.getYears());
        System.out.println("Number of days of Independence:"+period.getDays());
        System.out.println("Number of months of Independence:"+period.getMonths());

        //finding the joining date
        LocalDate start1 = LocalDate.of(2024, Month.SEPTEMBER,23);
        LocalDate end1 = LocalDate.now();
        Period period1 = Period.between(start1, end1);

        System.out.println("Number of days of joining:"+period1.getDays());
        System.out.println("Number of months of joining:"+period1.getMonths());








    }
}
