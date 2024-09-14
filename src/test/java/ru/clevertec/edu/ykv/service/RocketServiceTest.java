package ru.clevertec.edu.ykv.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;
import ru.clevertec.edu.ykv.exception.RocketNotFoundException;
import ru.clevertec.edu.ykv.mapper.RocketMapper;
import ru.clevertec.edu.ykv.repository.RocketRepository;
import ru.clevertec.edu.ykv.util.DateSupplierTestPeriod;
import ru.clevertec.edu.ykv.util.RocketTestData;
import ru.clevertec.edu.ykv.util.RocketTestDataByType;
import ru.clevertec.edu.ykv.util.RocketTestDataEndedTestPeriod;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RocketServiceTest {

    @Mock
    private RocketRepository rocketRepository;
    @Mock
    private RocketMapper rocketMapper;

    @Spy
    private DateSupplierTestPeriod dateSupplier = new DateSupplierTestPeriod();

    @InjectMocks
    private RocketService rocketService;

    @Test
    void shouldCreateRocket() {
        //given
        Rocket rocket = RocketTestData.getRocketForCreate();
        RocketEntity rocketEntity = RocketTestData.getRocketEntityForCreate();

        RocketEntity createdRocketEntity = RocketTestData.getFillRocketEntity();
        Rocket createdRocket = RocketTestData.getFillRocket();

        when(rocketMapper.toEntity(rocket))
                .thenReturn(rocketEntity);
        when(rocketRepository.createRocket(rocketEntity))
                .thenReturn(createdRocketEntity);
        when(rocketMapper.toDomain(createdRocketEntity))
                .thenReturn(createdRocket);

        //when
        Rocket actualRocket = rocketService.createRocket(rocket);

        //then
        assertAll(
                () -> assertNotNull(actualRocket),
                () -> assertEquals(RocketTestData.ROCKET_UUID, actualRocket.getId()),
                () -> assertEquals(RocketTestData.ROCKET_NAME, actualRocket.getName()),
                () -> assertEquals(RocketTestData.ROCKET_TYPE, actualRocket.getRocketType()),
                () -> assertEquals(RocketTestData.ROCKET_COUNTRY, actualRocket.getCountry()),
                () -> assertEquals(RocketTestData.CURRENT_DATE, actualRocket.getStartTestPeriod()),
                () -> assertEquals(RocketTestData.CURRENT_DATE_PLUS_MONTH, actualRocket.getEndTestPeriod())
        );

        verify(rocketMapper, times(1)).toEntity(rocket);
        verify(rocketRepository, times(1)).createRocket(rocketEntity);
        verify(rocketMapper, times(1)).toDomain(createdRocketEntity);
    }

    @Test
    void shouldGetRockets() {
        //given
        List<RocketEntity> rocketEntities = RocketTestData.getListWithFiveRocketEntities();
        List<Rocket> rockets = RocketTestData.getListWithFiveRockets();

        when(rocketRepository.getRockets()).thenReturn(rocketEntities);
        when(rocketMapper.toDomains(rocketEntities))
                .thenReturn(rockets);

        //when
        List<Rocket> actualRockets = rocketService.getRockets();

        //then
        assertEquals(5, actualRockets.size());

        verify(rocketRepository, times(1)).getRockets();
        verify(rocketMapper, times(1)).toDomains(rocketEntities);
    }

    @Nested
    class getById {

        @Test
        void shouldGetRocketById() {
            //given
            UUID rocketId = RocketTestData.ROCKET_UUID;
            Rocket rocket = RocketTestData.getFillRocket();
            RocketEntity rocketEntity = RocketTestData.getFillRocketEntity();

            when(rocketRepository.getRocketById(rocketId)).thenReturn(Optional.of(rocketEntity));
            when(rocketMapper.toDomain(rocketEntity)).thenReturn(rocket);

            //when
            Rocket actualRocket = rocketService.getRocketById(rocketId);

            //then
            assertAll(
                    () -> assertNotNull(actualRocket),
                    () -> assertEquals(rocketId, actualRocket.getId()),
                    () -> assertEquals(RocketTestData.ROCKET_NAME, actualRocket.getName()),
                    () -> assertEquals(RocketTestData.ROCKET_TYPE, actualRocket.getRocketType()),
                    () -> assertEquals(RocketTestData.ROCKET_COUNTRY, actualRocket.getCountry()),
                    () -> assertEquals(RocketTestData.CURRENT_DATE, actualRocket.getStartTestPeriod()),
                    () -> assertEquals(RocketTestData.CURRENT_DATE_PLUS_MONTH, actualRocket.getEndTestPeriod())
            );

            verify(rocketRepository, times(1)).getRocketById(rocketId);
            verify(rocketMapper, times(1)).toDomain(rocketEntity);

        }

        @Test
        void shouldNotGetRocketById_whenRocketByIdNotFound() {
            //given
            UUID rocketId = RocketTestData.ROCKET_UUID;
            when(rocketRepository.getRocketById(rocketId)).thenThrow(RocketNotFoundException.class);

            //when, then
            assertThrows(RocketNotFoundException.class,
                    () -> rocketService.getRocketById(rocketId));

            verify(rocketRepository, times(1)).getRocketById(rocketId);
            verify(rocketMapper, times(0)).toDomain(any());
        }
    }

    @ParameterizedTest
    @EnumSource(RocketType.class)
    void shouldGetRocketEntitiesByType(RocketType rocketType) {
        //given
        List<RocketEntity> rocketEntities = RocketTestDataByType.getListRocketEntitiesByType(rocketType);
        List<Rocket> rockets = RocketTestDataByType.getListRocketsByType(rocketType);

        when(rocketRepository.getRocketsByType(rocketType))
                .thenReturn(rocketEntities);
        when(rocketMapper.toDomains(rocketEntities))
                .thenReturn(rockets);

        //when
        List<Rocket> actualRocketEntities = rocketService.getRocketsByType(rocketType);

        //then
        assertEquals(3, actualRocketEntities.size());

        verify(rocketRepository, times(1)).getRocketsByType(rocketType);
        verify(rocketMapper, times(1)).toDomains(rocketEntities);
    }

    @Test
    void shouldGetRocketEntitiesEndedTest() {
        //given
        List<RocketEntity> rocketEntities = RocketTestDataEndedTestPeriod.getListWithFiveRocketEntities();
        List<Rocket> rockets = RocketTestDataEndedTestPeriod.getListWithFiveRockets();
        LocalDate currentDate = dateSupplier.getCurrentDate();

        when(rocketRepository.getRocketsEndedTest(currentDate))
                .thenReturn(rocketEntities);
        when(rocketMapper.toDomains(rocketEntities))
                .thenReturn(rockets);

        //when
        List<Rocket> actualRocketEntities = rocketService.getRocketsEndedTestPeriod();

        //then
        assertAll(
                () -> assertEquals(5, actualRocketEntities.size()),
                () -> assertTrue(actualRocketEntities
                        .stream()
                        .allMatch(rocket -> rocket.getEndTestPeriod().isBefore(currentDate)))
        );

        verify(rocketRepository, times(1)).getRocketsEndedTest(currentDate);
        verify(rocketMapper, times(1)).toDomains(rocketEntities);
    }

    @Nested
    class update {

        @Test
        void shouldUpdateRocket() {
            //given
            UUID rocketId = RocketTestData.ROCKET_UUID;
            Rocket rocket = RocketTestData.getFillRocketForUpdate();
            RocketEntity rocketEntity = RocketTestData.getFillRocketEntityForUpdate();

            when(rocketMapper.toEntity(rocket))
                    .thenReturn(rocketEntity);
            when(rocketRepository.updateRocket(rocketId, rocketEntity))
                    .thenReturn(Optional.of(rocketEntity));
            when(rocketMapper.toDomain(rocketEntity))
                    .thenReturn(rocket);

            //when
            Rocket actualRocket = rocketService.updateRocket(rocketId, rocket);

            //then
            assertAll(
                    () -> assertNotNull(actualRocket),
                    () -> assertEquals(rocketId, actualRocket.getId()),
                    () -> assertEquals(RocketTestData.ROCKET_NAME_UPDATE, actualRocket.getName()),
                    () -> assertEquals(RocketTestData.ROCKET_TYPE_UPDATE, actualRocket.getRocketType()),
                    () -> assertEquals(RocketTestData.ROCKET_COUNTRY_UPDATE, actualRocket.getCountry()),
                    () -> assertEquals(RocketTestData.CURRENT_DATE, actualRocket.getStartTestPeriod()),
                    () -> assertEquals(RocketTestData.CURRENT_DATE_PLUS_MONTH, actualRocket.getEndTestPeriod())
            );

            verify(rocketMapper, times(1)).toEntity(rocket);
            verify(rocketRepository, times(1)).updateRocket(rocketId, rocketEntity);
            verify(rocketMapper, times(1)).toDomain(rocketEntity);
        }

        @Test
        void shouldNotUpdateRocket_whetRocketNotFound() {
            //given
            UUID rocketId = RocketTestData.ROCKET_UUID;
            Rocket rocket = RocketTestData.getFillRocket();
            RocketEntity rocketEntity = RocketTestData.getFillRocketEntity();

            when(rocketMapper.toEntity(rocket)).thenReturn(rocketEntity);
            when(rocketRepository.updateRocket(rocketId, rocketEntity))
                    .thenReturn(Optional.empty());

            //when, then
            assertThrows(RocketNotFoundException.class,
                    () -> rocketService.updateRocket(rocketId, rocket));

            verify(rocketMapper, times(1)).toEntity(rocket);
            verify(rocketRepository, times(1)).updateRocket(rocketId, rocketEntity);
            verify(rocketMapper, times(0)).toDomain(rocketEntity);
        }

    }


}