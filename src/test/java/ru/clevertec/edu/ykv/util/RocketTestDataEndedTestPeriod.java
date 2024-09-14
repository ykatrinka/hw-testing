package ru.clevertec.edu.ykv.util;

import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;

import java.util.List;
import java.util.UUID;

public class RocketTestDataEndedTestPeriod {
    public static List<RocketEntity> getListWithFiveRocketEntities() {
        return List.of(
                new RocketEntity(
                        UUID.randomUUID(),
                        "Space",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Sugar Rocket",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Pottery Rocket",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                )
        );
    }

    public static List<Rocket> getListWithFiveRockets() {
        return List.of(
                new Rocket(
                        UUID.randomUUID(),
                        "Space",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Sugar Rocket",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Pottery Rocket",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE.minusMonths(2),
                        RocketTestData.CURRENT_DATE.minusMonths(1)
                )
        );
    }

}
