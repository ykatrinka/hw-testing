package ru.clevertec.edu.ykv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.edu.ykv.common.RocketType;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rocket {

    private UUID id;
    private String name;
    private RocketType rocketType;
    private String country;
    private LocalDate startTestPeriod;
    private LocalDate endTestPeriod;
}
