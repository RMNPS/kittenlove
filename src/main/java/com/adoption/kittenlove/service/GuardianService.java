package com.adoption.kittenlove.service;

import com.adoption.kittenlove.data.Guardian;
import java.util.List;
import java.util.Optional;

public interface GuardianService {

    List<Guardian> getAllGuardians();

    Optional<Guardian> getGuardianDetails(int id);

    Guardian save(Guardian cat);
}
