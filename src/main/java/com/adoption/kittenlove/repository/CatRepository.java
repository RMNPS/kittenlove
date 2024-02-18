package com.adoption.kittenlove.repository;

import com.adoption.kittenlove.data.Adoption;
import com.adoption.kittenlove.data.Cat;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface CatRepository extends Repository<Cat, Integer> {

    List<Cat> findAll();

    Cat save(Cat entity);

    Optional<Cat> findById(Integer integer);
}
