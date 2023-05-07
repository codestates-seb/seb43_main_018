package com.codestates.Maker;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MakersMapper {
    MakersDto toDto(Makers makers);
}



