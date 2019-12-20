package com.felix.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.Objects.requireNonNull;

public class Dates {

    public static Date of(int year, int month, int day) {
        return toDate(LocalDate.of(year, month, day));
    }

    public static Date of(int year, int month, int day, int hour, int minute, int second) {
        return toDate(LocalDateTime.of(year, month, day, hour, minute, second));
    }

    public static Date of(int year, int month, int day, int hour, int minute) {
        return toDate(LocalDateTime.of(year, month, day, hour, minute, 0));
    }

    public static Date toDate(LocalDate date) {
        requireNonNull(date, "Date is null.");
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDateTime date) {
        requireNonNull(date, "Date is null.");
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static int getDayOfMonth(Date date) {
        requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Date date) {
        requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static LocalDate toLocalDate(Date date) {
        requireNonNull(date, "Date is null.");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        requireNonNull(date, "Date is null.");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String format(Date date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        return new SimpleDateFormat(format).format(date);
    }

    public static String format(LocalDate date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static String format(LocalDateTime date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static Date parseDate(String date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid format.");
        }
    }

    public static List<LocalDate> getInterval(LocalDate start, LocalDate end, ChronoUnit chrono) {
        requireNonNull(start, "Start date is null.");
        requireNonNull(end, "End date is null.");
        requireNonNull(chrono, "ChronoUnit is null.");

        if (start.isAfter(end))
            throw new IllegalArgumentException("Start date is after end date.");

        LongFunction<LocalDate> incrementDate = i -> {
            switch (chrono) {
                case DAYS: return start.plusDays(i);
                case MONTHS: return start.plusMonths(i);
                case YEARS: return start.plusYears(i);
                default: return null;
            }
        };

        return LongStream.range(0, getPeriod(start, end, chrono) + 1)
                .mapToObj(incrementDate)
                .collect(Collectors.toList());
    }

    public static List<LocalDateTime> getInterval(LocalDateTime start, LocalDateTime end, ChronoUnit chrono) {
        requireNonNull(start, "Start date is null.");
        requireNonNull(end, "End date is null.");
        requireNonNull(chrono, "ChronoUnit is null.");

        if (start.isAfter(end))
            throw new IllegalArgumentException("Start date is after end date.");

        LongFunction<LocalDateTime> incrementDate = i -> {
            switch (chrono) {
                case DAYS: return start.plusDays(i);
                case MONTHS: return start.plusMonths(i);
                case YEARS: return start.plusYears(i);
                case HOURS: return start.plusHours(i);
                case MINUTES: return start.plusMinutes(i);
                case SECONDS: return start.plusSeconds(i);
                default: return null;
            }
        };

        return LongStream.range(0, getPeriod(start, end, chrono) + 1)
                .mapToObj(incrementDate)
                .collect(Collectors.toList());
    }

    public static long getPeriod(LocalDate start, LocalDate end, ChronoUnit chrono) {
        requireNonNull(start, "Start date is null.");
        requireNonNull(end, "End date is null.");
        requireNonNull(chrono, "ChronoUnit is null.");
        return ChronoUnit.valueOf(chrono.name()).between(start, end);
    }

    public static long getPeriod(LocalDateTime start, LocalDateTime end, ChronoUnit chrono) {
        requireNonNull(start, "Start date is null.");
        requireNonNull(end, "End date is null.");
        requireNonNull(chrono, "ChronoUnit is null.");
        return ChronoUnit.valueOf(chrono.name()).between(start, end);
    }
}
