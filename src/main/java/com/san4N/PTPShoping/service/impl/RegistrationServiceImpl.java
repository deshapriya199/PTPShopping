package com.san4N.PTPShoping.service.impl;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.entity.User;
import com.san4N.PTPShoping.mapper.RegistrationDTOMapper;
import com.san4N.PTPShoping.mapper.UserDTOMapper;
import com.san4N.PTPShoping.repository.UserRepository;
import com.san4N.PTPShoping.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDTO register(RegistrationDTO registrationDTO) {
        User user = RegistrationDTOMapper.INSTANCE.getUser(registrationDTO);
        user.setStatus(User.STATUS_NEW);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return UserDTOMapper.INSTANCE.getUserDTOFromUser(savedUser);
    }

    @Override
    public int activate(Long userId, String secret) {
        User userOptional = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("user not exist"));
        return userRepository.activateUser(userId);
    }
}
