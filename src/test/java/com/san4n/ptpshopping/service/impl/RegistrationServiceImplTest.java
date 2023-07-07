package com.san4n.ptpshopping.service.impl;

import com.san4n.ptpshopping.dto.RegistrationDTO;
import com.san4n.ptpshopping.dto.UserDTO;
import com.san4n.ptpshopping.entity.core.User;
import com.san4n.ptpshopping.mapper.RegistrationDTOMapper;
import com.san4n.ptpshopping.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @Test
    void givenRegistrationDTO_whenCreateNewUser_thenReturnCreatedUser () {
        RegistrationDTO registrationDTO = RegistrationDTO.builder()
                .email("sample@gmail.com")
                .userName("sample")
                .name("sample")
                .password("1233")
                .build();

        User user = RegistrationDTOMapper.INSTANCE.getUser(registrationDTO);
        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUserName(user.getUsername());
        savedUser.setEmail(user.getEmail());
        savedUser.setName(user.getName());
        savedUser.setStatus(User.STATUS_ACTIVE);
        savedUser.setPassword("encripted");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDTO userDTO = registrationService.register(registrationDTO);

        Assertions.assertNotNull(userDTO.id());
        Assertions.assertEquals(savedUser.getUsername(), userDTO.userName());
        Assertions.assertEquals(savedUser.getEmail(), userDTO.email());
        Assertions.assertEquals(savedUser.getName(), userDTO.name());

        verify(userRepository, times(1)).save(any(User.class));
    }
}
