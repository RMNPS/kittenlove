package com.adoption.kittenlove.service.impl;

import com.adoption.kittenlove.data.Adoption;
import com.adoption.kittenlove.exception.AlreadyAdoptedException;
import com.adoption.kittenlove.repository.AdoptionRepository;
import com.adoption.kittenlove.service.AdoptionService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AdoptionServiceImpl implements AdoptionService {


    AdoptionRepository adoptionRepository;

    public AdoptionServiceImpl(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }

    @Override
    public List<Adoption> getAllAdoptions() {
        return adoptionRepository.findAll();
    }

    @Override
    public Optional<Adoption> getAdoptionDetails(int id) {
        return adoptionRepository.findById(id);
    }

    @Override
    public Adoption save(Adoption adoption) {
        validate(adoption);

        return adoptionRepository.save(adoption);
    }

    private void validate(Adoption adoption) throws AlreadyAdoptedException {
        if (!isAvailableForAdoption(adoption)) {
            throw new AlreadyAdoptedException();
        }
    }

    private boolean isAvailableForAdoption(Adoption adoption) {
        return  adoptionRepository.isAvailable(adoption.getCat());
    }

}
