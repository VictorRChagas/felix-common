package com.felix.common.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.felix.common.date.Dates.*;
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
    void getIntervalWithLocalDateTest() {
        List<LocalDate> dates = getInterval(specificLocalDate, specificLocalDate.plusDays(10), IntervalType.DAY);

        assertEquals(11, dates.size());

        assertThat(getInterval(specificLocalDate, specificLocalDate, IntervalType.DAY),
                is(Collections.singletonList(specificLocalDate)));

        assertThrows(NullPointerException.class, () ->
                getInterval(null, specificLocalDate.plusDays(1), IntervalType.DAY), "Start date is null.");

        assertThrows(NullPointerException.class, () ->
                getInterval(specificLocalDate, null, IntervalType.DAY), "End date is null.");

        assertThrows(NullPointerException.class, () ->
                getInterval(specificLocalDate, specificLocalDate.plusDays(1), null), "IntervalType is null.");

        assertThrows(IllegalArgumentException.class, () ->
                getInterval(specificLocalDate, specificLocalDate.minusDays(1), IntervalType.DAY), "Start date is after end date.");
    }
}
