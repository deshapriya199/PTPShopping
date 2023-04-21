package com.san4N.PTPShoping.service.impl;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.entity.User;
import com.san4N.PTPShoping.mapper.RegistrationDTOMapper;
import com.san4N.PTPShoping.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @Test
    public void givenRegistrationDTO_whenCreateNewUser_thenReturnCreatedUser () {
        RegistrationDTO registrationDTO = RegistrationDTO.builder()
                .email("sample@gmail.com")
                .userName("sample")
                .name("sample")
                .password("1233")
                .build();

        User user = RegistrationDTOMapper.INSTANCE.getUser(registrationDTO);
        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUserName(user.getUserName());
        savedUser.setEmail(user.getEmail());
        savedUser.setName(user.getName());

        when(userRepository.save(user)).thenReturn(savedUser);

        UserDTO userDTO = registrationService.register(registrationDTO);

        Assertions.assertNotNull(userDTO.id());
        Assertions.assertEquals(savedUser.getUserName(), userDTO.userName());
        Assertions.assertEquals(savedUser.getEmail(), userDTO.email());
        Assertions.assertEquals(savedUser.getName(), userDTO.name());

        verify(userRepository, times(1)).save(user);
    }
}
