package com.felix.common.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.felix.common.date.Dates.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DatesTest {

    private Date specificDate = of(2019, 12, 18, 19, 25, 11);
    private LocalDate specificLocalDate = LocalDate.of(2019, 12, 18);
    private LocalDateTime specificLocalDateTime = LocalDateTime.of(2019, 12, 18, 19, 25, 11);

    @Test
    void ofDateTest() {
        Date date = of(2019, 12, 18);
        assertDate(date);
    }

    @Test
    void toDateTest() {
        Date date = Dates.toDate(specificLocalDate);
        assertDate(date);
        assertThrows(NullPointerException.class, () -> Dates.toDate((LocalDate) null));
    }

    private void assertDate(Date date) {
        assertEquals(18, getDayOfMonth(date));
        assertEquals(12, getMonth(date));
        assertEquals(2019, getYear(date));
    }

    @Test
    void getDayOfMonthTest() {
        assertEquals(18, getDayOfMonth(specificDate));
        assertThrows(NullPointerException.class, () -> getDayOfMonth(null));
    }

    @Test
    void getMonthTest() {
        assertEquals(12, getMonth(specificDate));
        assertThrows(NullPointerException.class, () -> getMonth(null));
    }

    @Test
    void getYearTest() {
        assertEquals(2019, getYear(specificDate));
        assertThrows(NullPointerException.class, () -> getYear(null));
    }

    @Test
    void toLocalDateTest() {
        assertLocalDate(toLocalDate(specificDate));
    }

    private void assertLocalDate(LocalDate localDate) {
        assertEquals(18, localDate.getDayOfMonth());
        assertEquals(12, localDate.getMonthValue());
        assertEquals(2019, localDate.getYear());
    }

    @Test
    void toLocalDateTimeTest() {
        LocalDateTime localDateTime = toLocalDateTime(specificDate);
        assertLocalDate(localDateTime.toLocalDate());
        assertEquals(19, localDateTime.getHour());
        assertEquals(25, localDateTime.getMinute());
        assertEquals(11, localDateTime.getSecond());
    }

    @Test
    void formatWithDateTest() {
        assertEquals("18/12/2019", format(specificDate, "dd/MM/yyyy"));
        assertThrows(NullPointerException.class, () -> format((Date) null, "dd/MM/yyyy"), "Date is null.");
        assertThrows(NullPointerException.class, () -> format(specificDate, null), "Format is null.");
    }

    @Test
    void formatWithLocalDateTest() {
        assertEquals("18/12/2019", format(specificLocalDate, "dd/MM/yyyy"));
        assertThrows(NullPointerException.class, () -> format((Date) null, "dd/MM/yyyy"), "Date is null.");
        assertThrows(NullPointerException.class, () -> format(specificLocalDate, null), "Format is null.");
    }

    @Test
    void formatWithLocalDateTimeTest() {
        assertEquals("18/12/2019 19:25:11", format(specificLocalDateTime, "dd/MM/yyyy HH:mm:ss"));
        assertThrows(NullPointerException.class, () -> format((Date) null, "dd/MM/yyyy"), "Date is null.");
        assertThrows(NullPointerException.class, () -> format(specificLocalDateTime, null), "Format is null.");
    }

    @Test
    void parseDateTest() {
        assertEquals(specificDate, parseDate("2019-12-18 19:25:11", "yyyy-MM-dd HH:mm:ss"));
        assertThrows(IllegalArgumentException.class,
                () -> parseDate("2019/12/18 19:25:11", "yyyy-MM-dd HH:mm:ss"), "Invalid format.");
        assertThrows(NullPointerException.class, () -> parseDate(null, "yyyy/MM/dd HH:mm:ss"), "Date is null.");
        assertThrows(NullPointerException.class, () -> parseDate("2019-12-18 19:25:11", null), "Format is null.");
    }

    @Test
    void getIntervalWithLocalDateDayTest() {
        List<LocalDate> dates = getInterval(specificLocalDate, specificLocalDate.plusDays(10), ChronoUnit.DAYS);

        assertEquals(11, dates.size());

        assertThat(getInterval(specificLocalDate, specificLocalDate, ChronoUnit.DAYS),
                is(Collections.singletonList(specificLocalDate)));

        assertThrows(NullPointerException.class, () ->
                getInterval(null, specificLocalDate.plusDays(1), ChronoUnit.DAYS), "Start date is null.");

        assertThrows(NullPointerException.class, () ->
                getInterval(specificLocalDate, null, ChronoUnit.DAYS), "End date is null.");

        assertThrows(NullPointerException.class, () ->
                getInterval(specificLocalDate, specificLocalDate.plusDays(1), null), "ChronoUnit is null.");

        assertThrows(IllegalArgumentException.class, () ->
                getInterval(specificLocalDate, specificLocalDate.minusDays(1), ChronoUnit.DAYS), "Start date is after end date.");
    }

    @Test
    void getIntervalWithLocalDateMonthTest() {
        List<LocalDate> dates = getInterval(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 12, 1), ChronoUnit.MONTHS);
        assertEquals(12, dates.size());
        assertThat(dates, hasItems(LocalDate.of(2019, 10, 1), LocalDate.of(2019, 9, 1)));

        dates = getInterval(LocalDate.of(2018, 1, 1), LocalDate.of(2019, 12, 1), ChronoUnit.MONTHS);
        assertEquals(24, dates.size());
        assertThat(dates, hasItems(LocalDate.of(2018, 10, 1), LocalDate.of(2019, 9, 1)));
    }

    @Test
    void getIntervalWithLocalDateYearTest() {
        List<LocalDate> dates = getInterval(LocalDate.of(2000, 1, 1), LocalDate.of(2019, 12, 1), ChronoUnit.YEARS);
        assertEquals(20, dates.size());
        assertThat(dates, hasItems(LocalDate.of(2015, 1, 1), LocalDate.of(2019, 1, 1)));
    }

    @Test
    void getIntervalWithLocalDateTimeHourTest() {
        List<LocalDateTime> dates = getInterval(specificLocalDateTime, specificLocalDateTime.plusHours(24), ChronoUnit.HOURS);

        assertEquals(25, dates.size());

        assertThat(getInterval(specificLocalDateTime, specificLocalDateTime, ChronoUnit.HOURS),
                is(Collections.singletonList(specificLocalDateTime)));

        assertThrows(NullPointerException.class, () ->
                getInterval(null, specificLocalDateTime.plusDays(1), ChronoUnit.HOURS), "Start date is null.");

        assertThrows(NullPointerException.class, () ->
                getInterval(specificLocalDateTime, null, ChronoUnit.HOURS), "End date is null.");

        assertThrows(NullPointerException.class, () ->
                getInterval(specificLocalDateTime, specificLocalDateTime.plusDays(1), null), "ChronoUnit is null.");

        assertThrows(IllegalArgumentException.class, () ->
                getInterval(specificLocalDateTime, specificLocalDateTime.minusDays(1), ChronoUnit.HOURS), "Start date is after end date.");
    }

    @Test
    void getPeriodWithLocalDateTest() {
        assertEquals(30, getPeriod(specificLocalDate, specificLocalDate.plusDays(30), ChronoUnit.DAYS));
        assertEquals(30, getPeriod(specificLocalDate, specificLocalDate.plusMonths(30), ChronoUnit.MONTHS));
        assertEquals(30, getPeriod(specificLocalDate, specificLocalDate.plusYears(30), ChronoUnit.YEARS));

        assertThrows(NullPointerException.class, () -> getPeriod(null, specificLocalDate, ChronoUnit.DAYS), "Start date is null.");
        assertThrows(NullPointerException.class, () -> getPeriod(specificLocalDate, null, ChronoUnit.DAYS), "End date is null.");
        assertThrows(NullPointerException.class, () -> getPeriod(null, specificLocalDate, null), "ChronoUnit is null.");
    }

    @Test
    void getPeriodWithLocalDateTimeTest() {
        assertEquals(30, getPeriod(specificLocalDateTime, specificLocalDateTime.plusDays(30), ChronoUnit.DAYS));
        assertEquals(30, getPeriod(specificLocalDateTime, specificLocalDateTime.plusHours(30), ChronoUnit.HOURS));
        assertEquals(30, getPeriod(specificLocalDateTime, specificLocalDateTime.plusMinutes(30), ChronoUnit.MINUTES));
        assertEquals(30, getPeriod(specificLocalDateTime, specificLocalDateTime.plusSeconds(30), ChronoUnit.SECONDS));

        assertThrows(NullPointerException.class, () -> getPeriod(null, specificLocalDate, ChronoUnit.DAYS), "Start date is null.");
        assertThrows(NullPointerException.class, () -> getPeriod(specificLocalDate, null, ChronoUnit.DAYS), "End date is null.");
        assertThrows(NullPointerException.class, () -> getPeriod(null, specificLocalDate, null), "ChronoUnit is null.");
    }
}
