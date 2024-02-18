package com.adoption.kittenlove.repository;

import com.adoption.kittenlove.data.Guardian;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface GuardianRepository extends Repository<Guardian, Integer> {

    List<Guardian> findAll();

    Guardian save(Guardian entity);

    Optional<Guardian> findById(Integer integer);

    List<Guardian> findAllByName(String name);
}
