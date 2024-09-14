package ru.clevertec.edu.ykv.helper;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UuidSupplier {

    UUID generateUuid();
}
