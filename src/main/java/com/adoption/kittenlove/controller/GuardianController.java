package com.adoption.kittenlove.controller;

import com.adoption.kittenlove.dto.GuardianDTO;
import com.adoption.kittenlove.service.GuardianService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqids.Sqids;

@RestController
@RequestMapping("/api/guardians")
public class GuardianController {

    private final GuardianService guardianService;

    private final ModelMapper modelMapper;
    private final Sqids sqids;

    public GuardianController(GuardianService guardianService, ModelMapper modelMapper, Sqids sqids) {
        this.guardianService = guardianService;
        this.modelMapper = modelMapper;
        this.sqids = sqids;
    }

    @GetMapping
    public List<GuardianDTO> findAll() {
        return guardianService
                .getAllGuardians()
                .stream()
                .map(guardian -> modelMapper.map(guardian, GuardianDTO.class))
                .toList();
    }
}
