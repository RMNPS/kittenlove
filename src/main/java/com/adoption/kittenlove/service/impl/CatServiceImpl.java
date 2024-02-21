package com.adoption.kittenlove.service.impl;

import com.adoption.kittenlove.data.Cat;
import com.adoption.kittenlove.repository.CatRepository;
import com.adoption.kittenlove.service.CatService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    private CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Optional<Cat> getCatDetails(int id) {
        return catRepository.findById(id);
    }

    @Override
    public Cat save(Cat cat) {
        return catRepository.save(cat);
    }
}
