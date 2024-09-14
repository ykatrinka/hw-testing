package ru.clevertec.edu.ykv.helper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateSupplierRocket implements DateSupplier {
    @Override
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    @Override
    public LocalDate getCurrentDatePlusMonth() {
        return LocalDate.now().plusMonths(1);
    }
}
