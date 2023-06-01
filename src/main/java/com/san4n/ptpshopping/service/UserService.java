package com.san4n.ptpshopping.service;

import com.san4n.ptpshopping.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(Long userId);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    void deleteUserById(Long userId);
}
