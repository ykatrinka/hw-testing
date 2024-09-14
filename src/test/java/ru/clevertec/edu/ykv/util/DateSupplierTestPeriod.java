package ru.clevertec.edu.ykv.util;

import ru.clevertec.edu.ykv.helper.DateSupplier;

import java.time.LocalDate;

public class DateSupplierTestPeriod implements DateSupplier {
    @Override
    public LocalDate getCurrentDate() {
        return RocketTestData.CURRENT_DATE;
    }

    @Override
    public LocalDate getCurrentDatePlusMonth() {
        return RocketTestData.CURRENT_DATE.plusMonths(1);
    }
}
