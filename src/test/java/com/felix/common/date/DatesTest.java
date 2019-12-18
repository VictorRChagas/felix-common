package com.felix.common.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class DatesTest {

    private Date specificDate = Dates.of(2019, 12, 18);
    private LocalDate specificLocalDate = LocalDate.of(2019, 12, 18);

    @Test
    void ofDateTest() {
        Assertions.assertEquals(18, Dates.getDayOfMonth(specificDate));
        Assertions.assertEquals(12, Dates.getMonth(specificDate));
        Assertions.assertEquals(2019, Dates.getYear(specificDate));
    }

    @Test
    void toDateTest() {

        Date date = Dates.toDate(specificLocalDate);
        Assertions.assertEquals(18, Dates.getDayOfMonth(date));
        Assertions.assertEquals(12, Dates.getMonth(date));
        Assertions.assertEquals(2019, Dates.getYear(date));
    }

    @Test
    void getDayOfMonthTest() {

    }

    @Test
    void getMonthTest() {

    }

    @Test
    void getYearTest() {

    }

    @Test
    void toLocalDateTest() {

    }

    @Test
    void toLocalDateTimeTest() {

    }

    @Test
    void formatWithDateTest() {

    }

    @Test
    void formatWithLocalDateTest() {

    }
}
