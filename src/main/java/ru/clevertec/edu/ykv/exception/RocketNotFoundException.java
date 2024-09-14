package ru.clevertec.edu.ykv.exception;

import java.util.UUID;

public class RocketNotFoundException extends RuntimeException {
    private RocketNotFoundException(String message) {
        super(message);
    }

    public static RocketNotFoundException byRocketId(UUID rocketId) {
        return new RocketNotFoundException(
                String.format("Rocket not found by id %s", rocketId)
        );
    }

}
