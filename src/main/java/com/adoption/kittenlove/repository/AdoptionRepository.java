package com.adoption.kittenlove.repository;

import com.adoption.kittenlove.data.Adoption;
import com.adoption.kittenlove.data.Cat;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface AdoptionRepository extends Repository<Adoption, Integer> {

    @Query("SELECT count(e) <=0 FROM Adoption e "
            + "WHERE e.toDate is NOT NULL AND e.cat = :cat")
    boolean isAvailable(Cat cat);

    List<Adoption> findAll();

    Adoption save(Adoption entity);

    Optional<Adoption> findById(Integer integer);
}
