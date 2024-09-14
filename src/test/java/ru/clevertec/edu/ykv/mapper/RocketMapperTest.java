package ru.clevertec.edu.ykv.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;
import ru.clevertec.edu.ykv.util.RocketTestDataForMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class RocketMapperTest {

    @InjectMocks
    private RocketMapper rocketMapper = new RocketMapperImpl();

    @Test
    void shouldConvertEntitiesToDomains() {
        //given
        int count = 5;
        List<RocketEntity> rocketEntities = RocketTestDataForMapper.getRocketEntitiesForMapper(count);

        //when
        List<Rocket> actualRockets = rocketMapper.toDomains(rocketEntities);

        //then
        assertAll(
                () -> assertNotNull(actualRockets),
                () -> assertEquals(rocketEntities.size(), actualRockets.size())
        );
    }

    @Test
    void shouldConvertEntitiesToDomains_whenEntitiesIsNull() {
        //given

        //when
        List<Rocket> actualRockets = rocketMapper.toDomains(null);

        //then
        assertNull(actualRockets);
    }

    @Test
    void shouldConvertEntityToDomain() {
        //given
        RocketEntity rocketEntity = RocketTestDataForMapper.getRocketEntityForMapper();

        //when
        Rocket actualRocket = rocketMapper.toDomain(rocketEntity);

        //then
        assertAll(
                () -> assertNotNull(actualRocket),
                () -> assertEquals(rocketEntity.getId(), actualRocket.getId()),
                () -> assertEquals(rocketEntity.getName(), actualRocket.getName()),
                () -> assertEquals(rocketEntity.getRocketType(), actualRocket.getRocketType()),
                () -> assertEquals(rocketEntity.getCountry(), actualRocket.getCountry()),
                () -> assertEquals(rocketEntity.getStartTestPeriod(), actualRocket.getStartTestPeriod()),
                () -> assertEquals(rocketEntity.getEndTestPeriod(), actualRocket.getEndTestPeriod())
        );
    }

    @Test
    void shouldConvertEntityToDomain_whenEntityIsNull() {
        //given

        //when
        Rocket actualRocket = rocketMapper.toDomain(null);

        //then
        assertNull(actualRocket);
    }

    @Test
    void shouldConvertDomainToEntity() {
        //given
        Rocket rocket = RocketTestDataForMapper.getRocketForMapper();

        //when
        RocketEntity actualRocketEntity = rocketMapper.toEntity(rocket);

        //then
        assertAll(
                () -> assertNotNull(actualRocketEntity),
                () -> assertEquals(rocket.getId(), actualRocketEntity.getId()),
                () -> assertEquals(rocket.getName(), actualRocketEntity.getName()),
                () -> assertEquals(rocket.getRocketType(), actualRocketEntity.getRocketType()),
                () -> assertEquals(rocket.getCountry(), actualRocketEntity.getCountry()),
                () -> assertEquals(rocket.getStartTestPeriod(), actualRocketEntity.getStartTestPeriod()),
                () -> assertEquals(rocket.getEndTestPeriod(), actualRocketEntity.getEndTestPeriod())
        );
    }

    @Test
    void shouldConvertDomainToEntity_whenDomainIsNull() {
        //given

        //when
        RocketEntity actualRocket = rocketMapper.toEntity(null);

        //then
        assertNull(actualRocket);
    }
}