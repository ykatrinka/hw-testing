package ru.clevertec.edu.ykv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;
import ru.clevertec.edu.ykv.exception.RocketNotFoundException;
import ru.clevertec.edu.ykv.helper.DateSupplier;
import ru.clevertec.edu.ykv.mapper.RocketMapper;
import ru.clevertec.edu.ykv.repository.RocketRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RocketService {

    private final RocketRepository rocketRepository;

    private final RocketMapper rocketMapper;
    private final DateSupplier dateSupplier;


    public Rocket createRocket(Rocket rocket) {
        RocketEntity rocketEntity = rocketMapper.toEntity(rocket);
        rocketEntity.setStartTestPeriod(dateSupplier.getCurrentDate());
        rocketEntity.setEndTestPeriod(dateSupplier.getCurrentDatePlusMonth());

        RocketEntity createdRocket = rocketRepository.createRocket(rocketEntity);
        return rocketMapper.toDomain(createdRocket);
    }

    public List<Rocket> getRockets() {
        List<RocketEntity> rockets = rocketRepository.getRockets();
        return rocketMapper.toDomains(rockets);
    }

    public Rocket getRocketById(UUID rocketId) {
        RocketEntity rocketEntity = rocketRepository.getRocketById(rocketId)
                .orElseThrow(() -> RocketNotFoundException.byRocketId(rocketId));

        return rocketMapper.toDomain(rocketEntity);
    }

    public List<Rocket> getRocketsByType(RocketType rocketType) {
        List<RocketEntity> rocketEntity = rocketRepository.getRocketsByType(rocketType);

        return rocketMapper.toDomains(rocketEntity);
    }

    public List<Rocket> getRocketsEndedTestPeriod() {
        LocalDate currentDate = dateSupplier.getCurrentDate();
        List<RocketEntity> rocketEntity = rocketRepository.getRocketsEndedTest(currentDate);

        return rocketMapper.toDomains(rocketEntity);
    }

    public Rocket updateRocket(UUID rocketId, Rocket rocket) {
        RocketEntity rocketEntity = rocketMapper.toEntity(rocket);
        RocketEntity updatedRocketEntity = rocketRepository.updateRocket(rocketId, rocketEntity)
                .orElseThrow(() -> RocketNotFoundException.byRocketId(rocketId));

        return rocketMapper.toDomain(updatedRocketEntity);
    }

    public void delete(UUID rocketId) {
        rocketRepository.deleteRocket(rocketId);
    }
}
