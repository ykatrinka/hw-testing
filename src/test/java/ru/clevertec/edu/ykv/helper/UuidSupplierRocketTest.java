package ru.clevertec.edu.ykv.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.edu.ykv.util.RocketTestData;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UuidSupplierRocketTest {

    @Spy
    UuidSupplierRocket uuidSupplierRocket;

    @Test
    void shouldGenerateUuid() {
        //given
        UUID currentUuid = RocketTestData.ROCKET_UUID;
        when(uuidSupplierRocket.generateUuid()).thenReturn(currentUuid);

        //when
        UUID actualCurrentUuid = uuidSupplierRocket.generateUuid();

        //then
        assertEquals(currentUuid, actualCurrentUuid);
    }
}