package com.adoption.kittenlove.service;

import com.adoption.kittenlove.data.Adoption;
import java.util.List;
import java.util.Optional;

public interface AdoptionService {

    List<Adoption> getAllAdoptions();

    Optional<Adoption> getAdoptionDetails(int id);

    Adoption save(Adoption adoption);
}
