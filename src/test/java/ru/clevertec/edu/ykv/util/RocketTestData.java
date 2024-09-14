package ru.clevertec.edu.ykv.util;

import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RocketTestData {
    public static final UUID ROCKET_UUID = UUID.fromString("32168d6b-03a1-444c-99a1-697cb00e55c2");

    public static final LocalDate CURRENT_DATE = LocalDate.of(2004, 6, 17);
    public static final LocalDate CURRENT_DATE_PLUS_MONTH = LocalDate.of(2004, 7, 17);
    public static final String ROCKET_NAME = "Space";
    public static final RocketType ROCKET_TYPE = RocketType.WOOD;
    public static final String ROCKET_COUNTRY = "The USA";

    public static final String ROCKET_NAME_UPDATE = "Space update";
    public static final RocketType ROCKET_TYPE_UPDATE = RocketType.SUGAR;
    public static final String ROCKET_COUNTRY_UPDATE = "The UK";


    public static RocketEntity getRocketEntityForCreate() {
        return new RocketEntity(
                null,
                ROCKET_NAME,
                ROCKET_TYPE,
                ROCKET_COUNTRY,
                null,
                null
        );
    }

    public static Rocket getRocketForCreate() {
        return new Rocket(
                null,
                ROCKET_NAME,
                ROCKET_TYPE,
                ROCKET_COUNTRY,
                null,
                null
        );
    }

    public static RocketEntity getFillRocketEntity() {
        return new RocketEntity(
                ROCKET_UUID,
                ROCKET_NAME,
                ROCKET_TYPE,
                ROCKET_COUNTRY,
                CURRENT_DATE,
                CURRENT_DATE_PLUS_MONTH
        );
    }

    public static Rocket getFillRocket() {
        return new Rocket(
                ROCKET_UUID,
                ROCKET_NAME,
                ROCKET_TYPE,
                ROCKET_COUNTRY,
                CURRENT_DATE,
                CURRENT_DATE_PLUS_MONTH
        );
    }


    public static List<RocketEntity> getListWithFiveRocketEntities() {
        return List.of(
                new RocketEntity(
                        UUID.randomUUID(),
                        "Space",
                        RocketType.WOOD,
                        "the USA",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PAPER,
                        "CHINA",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Sugar Rocket",
                        RocketType.SUGAR,
                        "FRANCE",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Pottery Rocket",
                        RocketType.POTTERY,
                        "CHINA",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new RocketEntity(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PLASTIC,
                        "GERMANY",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
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
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PAPER,
                        "CHINA",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Sugar Rocket",
                        RocketType.SUGAR,
                        "FRANCE",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Pottery Rocket",
                        RocketType.POTTERY,
                        "CHINA",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                ),
                new Rocket(
                        UUID.randomUUID(),
                        "Paper Rocket",
                        RocketType.PLASTIC,
                        "GERMANY",
                        CURRENT_DATE,
                        CURRENT_DATE_PLUS_MONTH
                )
        );
    }


    public static RocketEntity getFillRocketEntityForUpdate() {
        return new RocketEntity(
                ROCKET_UUID,
                ROCKET_NAME_UPDATE,
                ROCKET_TYPE_UPDATE,
                ROCKET_COUNTRY_UPDATE,
                CURRENT_DATE,
                CURRENT_DATE_PLUS_MONTH
        );
    }

    public static Rocket getFillRocketForUpdate() {
        return new Rocket(
                ROCKET_UUID,
                ROCKET_NAME_UPDATE,
                ROCKET_TYPE_UPDATE,
                ROCKET_COUNTRY_UPDATE,
                CURRENT_DATE,
                CURRENT_DATE_PLUS_MONTH
        );
    }
}
