package com.codestates.TrashCan;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrashCanMapper {

    TrashCanMapper INSTANCE = Mappers.getMapper(TrashCanMapper.class);

    TrashCanDto toDto(TrashCan trashCan);

    List<TrashCanDto> toDtoList(List<TrashCan> trashCans);

    @InheritInverseConfiguration
    TrashCan toEntity(TrashCanDto trashCanDto);

}
