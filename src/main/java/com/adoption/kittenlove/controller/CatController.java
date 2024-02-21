package com.adoption.kittenlove.controller;

import com.adoption.kittenlove.data.Cat;
import com.adoption.kittenlove.dto.CatDTO;
import com.adoption.kittenlove.exception.CatNotFoundException;
import com.adoption.kittenlove.service.CatService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqids.Sqids;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private final CatService catService;
    private final ModelMapper modelMapper;
    private final Sqids sqids;

    public CatController(CatService catService, ModelMapper modelMapper, Sqids sqids) {
        this.catService = catService;
        this.modelMapper = modelMapper;
        this.sqids = sqids;
    }

    @GetMapping(value = "/{id}")
    public CatDTO findById(@PathVariable("id") String id) {
        int decodedId = sqids
                .decode(id)
                .stream()
                .findFirst()
                .orElseThrow(CatNotFoundException::new)
                .intValue();

        Cat cat = catService
                .getCatDetails(decodedId)
                .orElseThrow(CatNotFoundException::new);

        return modelMapper
                .map(cat, CatDTO.class);
    }


    @GetMapping
    public List<CatDTO> findAll() {
        return catService
                .getAllCats()
                .stream()
                .map(cat -> modelMapper.map(cat, CatDTO.class))
                .toList();
    }


}
