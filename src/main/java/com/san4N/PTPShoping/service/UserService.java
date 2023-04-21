package com.san4N.PTPShoping.service;

import com.san4N.PTPShoping.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(Long userId);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    void deleteUserById(Long userId);
}
