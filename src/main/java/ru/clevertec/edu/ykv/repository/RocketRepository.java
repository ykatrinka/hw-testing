package ru.clevertec.edu.ykv.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.entity.RocketEntity;
import ru.clevertec.edu.ykv.helper.UuidSupplier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RocketRepository {
    private final List<RocketEntity> rocketEntities = new ArrayList<>();
    private final UuidSupplier uuidSupplier;


    public RocketEntity createRocket(RocketEntity rocketEntity) {
        UUID rocketId = uuidSupplier.generateUuid();

        rocketEntities.add(rocketEntity);
        rocketEntity.setId(rocketId);
        return rocketEntity;
    }

    public List<RocketEntity> getRockets() {
        return rocketEntities;
    }


    public Optional<RocketEntity> getRocketById(UUID rocketId) {
        return rocketEntities.stream()
                .filter(rocket -> rocketId.equals(rocket.getId()))
                .findFirst();
    }

    public List<RocketEntity> getRocketsByType(RocketType rocketType) {
        return rocketEntities.stream()
                .filter(rocket -> rocketType.equals(rocket.getRocketType()))
                .toList();
    }

    public List<RocketEntity> getRocketsEndedTest(LocalDate date) {
        return rocketEntities.stream()
                .filter(rocket -> rocket.getEndTestPeriod() != null)
                .filter(rocketEntity -> date.isAfter(rocketEntity.getEndTestPeriod()))
                .toList();
    }

    public Optional<RocketEntity> updateRocket(UUID rocketId, RocketEntity updatedRocketEntity) {
        return rocketEntities.stream()
                .filter(rocketEntity -> rocketId.equals(rocketEntity.getId()))
                .limit(1)
                .peek(
                        rocketEntity -> {
                            rocketEntity.setName(updatedRocketEntity.getName());
                            rocketEntity.setRocketType(updatedRocketEntity.getRocketType());
                            rocketEntity.setCountry(updatedRocketEntity.getCountry());
                            rocketEntity.setStartTestPeriod(updatedRocketEntity.getStartTestPeriod());
                            rocketEntity.setEndTestPeriod(updatedRocketEntity.getEndTestPeriod());
                        }
                )
                .findFirst();
    }

    public void deleteRocket(UUID rocketId) {
        rocketEntities.removeIf(rocketEntity -> rocketId.equals(rocketEntity.getId()));
    }
}
