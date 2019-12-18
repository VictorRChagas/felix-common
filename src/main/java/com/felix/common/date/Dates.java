package com.felix.common.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Dates {

    public static Date of(int year, int month, int day) {
        return toDate(LocalDate.of(year, month, day));
    }

    public static Date toDate(LocalDate date) {
        Objects.requireNonNull(date, "Date is null.");
        return java.sql.Date.valueOf(date);
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
        return cal.get(Calendar.MONTH);
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
        return new SimpleDateFormat(format).format(date);
    }

}
