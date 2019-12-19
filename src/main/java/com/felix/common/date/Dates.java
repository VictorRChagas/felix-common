package com.felix.common.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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
        Objects.requireNonNull(date, "Date is null.");
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDateTime date) {
        Objects.requireNonNull(date, "Date is null.");
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static int getDayOfMonth(Date date) {
        Objects.requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        Objects.requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Date date) {
        Objects.requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static LocalDate toLocalDate(Date date) {
        Objects.requireNonNull(date, "Date is null.");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        Objects.requireNonNull(date, "Date is null.");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String format(Date date, String format) {
        Objects.requireNonNull(date, "Date is null.");
        Objects.requireNonNull(format, "Format is null.");
        return new SimpleDateFormat(format).format(date);
    }

    public static String format(LocalDate date, String format) {
        Objects.requireNonNull(date, "Date is null.");
        Objects.requireNonNull(format, "Format is null.");
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static String format(LocalDateTime date, String format) {
        Objects.requireNonNull(date, "Date is null.");
        Objects.requireNonNull(format, "Format is null.");
        return date.format(DateTimeFormatter.ofPattern(format));
    }

}
