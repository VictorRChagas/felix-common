package com.felix.common.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static com.felix.common.date.Dates.*;
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
}
