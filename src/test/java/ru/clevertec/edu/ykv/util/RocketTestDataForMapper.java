package ru.clevertec.edu.ykv.util;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.misc.EnumRandomizer;
import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;

import java.util.List;

public class RocketTestDataForMapper {
    public static List<RocketEntity> getRocketEntitiesForMapper(int count) {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(20, 30)
                .scanClasspathForConcreteTypes(true)
                .randomize(RocketType.class,
                        () -> new EnumRandomizer<>(RocketType.class)
                                .getRandomValue())
                .dateRange(RocketTestData.CURRENT_DATE, RocketTestData.CURRENT_DATE.plusYears(20));

        EasyRandom generator = new EasyRandom(parameters);
        return generator.objects(RocketEntity.class, count).toList();
    }

    public static RocketEntity getRocketEntityForMapper() {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(20, 30)
                .scanClasspathForConcreteTypes(true)
                .randomize(RocketType.class,
                        () -> new EnumRandomizer<>(RocketType.class)
                                .getRandomValue())
                .dateRange(RocketTestData.CURRENT_DATE, RocketTestData.CURRENT_DATE.plusYears(20));

        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(RocketEntity.class);
    }

    public static Rocket getRocketForMapper() {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(20, 30)
                .scanClasspathForConcreteTypes(true)
                .randomize(RocketType.class,
                        () -> new EnumRandomizer<>(RocketType.class)
                                .getRandomValue())
                .dateRange(RocketTestData.CURRENT_DATE, RocketTestData.CURRENT_DATE.plusYears(20));

        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(Rocket.class);
    }
}
