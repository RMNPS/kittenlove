package com.adoption.kittenlove.service;

import com.adoption.kittenlove.data.Cat;
import java.util.List;
import java.util.Optional;

public interface CatService {

    List<Cat> getAllCats();

    Optional<Cat> getCatDetails(int id);

    Cat save(Cat cat);
}
