package ru.clevertec.edu.ykv.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.edu.ykv.util.RocketTestData;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DateSupplierRocketTest {

    @Spy
    DateSupplierRocket dateSupplierRocket;

    @Test
    void shouldGetCurrentDate() {
        //given
        LocalDate currentDay = RocketTestData.CURRENT_DATE;
        when(dateSupplierRocket.getCurrentDate()).thenReturn(currentDay);

        //when
        LocalDate actualCurrentDate = dateSupplierRocket.getCurrentDate();

        //then
        assertEquals(currentDay, actualCurrentDate);
    }

    @Test
    void shouldGetCurrentDatePlusMonth() {
        //given
        LocalDate currentDay = RocketTestData.CURRENT_DATE_PLUS_MONTH;
        when(dateSupplierRocket.getCurrentDate()).thenReturn(currentDay);

        //when
        LocalDate actualCurrentDate = dateSupplierRocket.getCurrentDate();

        //then
        assertEquals(currentDay, actualCurrentDate);
    }
}