package ru.clevertec.edu.ykv.util;

import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;

import java.util.List;
import java.util.UUID;

public class RocketTestDataByType {
    private static List<RocketEntity> getListRocketEntitiesForGetByType() {
        return List.of(
                new RocketEntity(
                        UUID.randomUUID(),
                        "Space",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Space 2",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Space 3",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket 2",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket 3",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Plastic Rocket",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Plastic Rocket 2",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Plastic Rocket 3",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Iron Rocket",
                        RocketType.IRON,
                        "ISRAEL",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Iron Rocket 2",
                        RocketType.IRON,
                        "ISRAEL",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Iron Rocket 3",
                        RocketType.IRON,
                        "ISRAEL",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Pottery Rocket",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Pottery Rocket 2",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Pottery Rocket 3",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Sugar Rocket",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Sugar Rocket 2",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Sugar Rocket 3",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                )
        );
    }

    private static List<Rocket> getListRocketsForGetByType() {
        return List.of(
                new Rocket(
                        UUID.randomUUID(),
                        "Space",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Space 2",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Space 3",
                        RocketType.WOOD,
                        "the USA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket 2",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket 3",
                        RocketType.PAPER,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Plastic Rocket",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Plastic Rocket 2",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Plastic Rocket 3",
                        RocketType.PLASTIC,
                        "GERMANY",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Iron Rocket",
                        RocketType.IRON,
                        "ISRAEL",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Iron Rocket 2",
                        RocketType.IRON,
                        "ISRAEL",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Iron Rocket 3",
                        RocketType.IRON,
                        "ISRAEL",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Pottery Rocket",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Pottery Rocket 2",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Pottery Rocket 3",
                        RocketType.POTTERY,
                        "CHINA",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Sugar Rocket",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Sugar Rocket 2",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Sugar Rocket 3",
                        RocketType.SUGAR,
                        "FRANCE",
                        RocketTestData.CURRENT_DATE,
                        RocketTestData.CURRENT_DATE_PLUS_MONTH
                )
        );
    }

    public static List<RocketEntity> getListRocketEntitiesByType(RocketType rocketType) {
        return getListRocketEntitiesForGetByType()
                .stream()
                .filter(rocket -> rocket.getRocketType() == rocketType)
                .toList();
    }

    public static List<Rocket> getListRocketsByType(RocketType rocketType) {
        return getListRocketsForGetByType()
                .stream()
                .filter(rocket -> rocket.getRocketType() == rocketType)
                .toList();
    }
}
