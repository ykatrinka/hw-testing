package ru.clevertec.edu.ykv.helper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface DateSupplier {
    LocalDate getCurrentDate();

    LocalDate getCurrentDatePlusMonth();
}
