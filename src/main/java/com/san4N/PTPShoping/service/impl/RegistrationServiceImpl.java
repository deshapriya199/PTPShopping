package com.san4N.PTPShoping.service.impl;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.entity.User;
import com.san4N.PTPShoping.repository.UserRepository;
import com.san4N.PTPShoping.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    @Override
    public void register(RegistrationDTO registrationDTO) {
        User user = new User();
        userRepository.save(user);
    }
}
