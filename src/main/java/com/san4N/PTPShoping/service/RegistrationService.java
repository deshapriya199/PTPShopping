package com.san4N.PTPShoping.service;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.dto.UserDTO;

public interface RegistrationService {

    UserDTO register(RegistrationDTO registrationDTO);

    void activate(Long userId, String secret);
}
