package com.san4N.PTPShoping.service.impl;

import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.entity.User;
import com.san4N.PTPShoping.mapper.UserDTOMapper;
import com.san4N.PTPShoping.repository.UserRepository;
import com.san4N.PTPShoping.service.UserService;
import com.san4N.PTPShoping.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userOptional.map(UserDTOMapper.INSTANCE::getUserDTOFromUser).get();

    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = EntityUtil.newEntity(userId, User.class, userRepository);
        UserDTOMapper.INSTANCE.getUserFromUserDTO(userDTO, user);
        User savedUser = userRepository.save(user);
        return UserDTOMapper.INSTANCE.getUserDTOFromUser(savedUser);
    }

    @Override
    public void deleteUserById(Long userId) {

    }
}
