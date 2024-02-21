package com.adoption.kittenlove.service.impl;

import com.adoption.kittenlove.data.Guardian;
import com.adoption.kittenlove.repository.GuardianRepository;
import com.adoption.kittenlove.service.GuardianService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GuardianServiceImpl implements GuardianService {

    private final GuardianRepository guardianRepository;

    public GuardianServiceImpl(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    @Override
    public List<Guardian> getAllGuardians() {
        return guardianRepository.findAll();
    }

    @Override
    public Optional<Guardian> getGuardianDetails(int id) {
        return guardianRepository.findById(id);
    }

    @Override
    public Guardian save(Guardian Guardian) {
        return guardianRepository.save(Guardian);
    }
}
