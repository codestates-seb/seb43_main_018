package com.codestates.Maker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/makers")
public class MakersController {
    private final MakersService makersService;

    public MakersController(MakersService makersService) {
        this.makersService = makersService;
    }

    @GetMapping("")
    public List<MakersDto> getAllMakers() {
        List<Makers> makersList = makersService.getAllMakers();
        return makersList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MakersDto getMakersById(@PathVariable Long id) {
        Makers makers = makersService.getMakersById(id);
        return makers != null ? convertToDto(makers) : null;
    }

    private MakersDto convertToDto(Makers makers) {
        MakersDto makersDto = new MakersDto();
        makersDto.setId(makers.getId());
        makersDto.setLongitude(makers.getLongitude());
        makersDto.setLatitude(makers.getLatitude());
        makersDto.setAddressGu(makers.getAddressGu());
        makersDto.setContainerType(makers.getContainerType());
        return makersDto;
    }
}

