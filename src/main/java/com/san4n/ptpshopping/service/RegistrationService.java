package com.san4n.ptpshopping.service;

import com.san4n.ptpshopping.dto.RegistrationDTO;
import com.san4n.ptpshopping.dto.UserDTO;

public interface RegistrationService {

    UserDTO register(RegistrationDTO registrationDTO);

    int activate(Long userId, String secret);
}
