package com.san4N.PTPShoping.service.impl;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.entity.User;
import com.san4N.PTPShoping.mapper.RegistrationDTOMapper;
import com.san4N.PTPShoping.mapper.UserDTOMapper;
import com.san4N.PTPShoping.repository.UserRepository;
import com.san4N.PTPShoping.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    @Override
    public UserDTO register(RegistrationDTO registrationDTO) {
        User user = RegistrationDTOMapper.INSTANCE.getUser(registrationDTO);
        user.setStatus(User.STATUS_NEW);
        User savedUser = userRepository.save(user);
        return UserDTOMapper.INSTANCE.getUserDTOFromUser(savedUser);
    }

    @Override
    public void activate(Long userId, String secret) {
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.ifPresent(user -> userRepository.activate(userId));
    }
}
