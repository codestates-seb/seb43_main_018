package com.codestates.Vote;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    VoteDto toDto(Vote vote);

    List<VoteDto> toDtoList(List<Vote> votes);

    @InheritInverseConfiguration
    Vote toEntity(VoteDto voteDto);

}

