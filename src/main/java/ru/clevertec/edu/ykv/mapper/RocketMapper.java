package ru.clevertec.edu.ykv.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.entity.RocketEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RocketMapper {

    List<Rocket> toDomains(List<RocketEntity> rocketEntities);

    Rocket toDomain(RocketEntity rocketEntity);

    RocketEntity toEntity(Rocket rocket);
}
