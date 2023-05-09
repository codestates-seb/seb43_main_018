package com.codestates.Maker;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MakersService {
    private final MakersRepository makersRepository;

    public MakersService(MakersRepository makersRepository) {
        this.makersRepository = makersRepository;
    }

    public List<Makers> getAllMakers() {
        return makersRepository.findAll();
    }

    public void save(Makers makers) {
        makersRepository.save(makers);
    }

    public Makers getMakersById(Long id) {
        return makersRepository.findById(id);
    }
}
