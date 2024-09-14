package ru.clevertec.edu.ykv.helper;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidSupplierRocket implements UuidSupplier {
    @Override
    public UUID generateUuid() {
        return UUID.randomUUID();
    }
}
