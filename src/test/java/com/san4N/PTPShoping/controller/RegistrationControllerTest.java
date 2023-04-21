package com.san4N.PTPShoping.controller;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.service.impl.RegistrationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {

    @Mock
    private RegistrationServiceImpl registrationService;

    @InjectMocks
    private RegistrationController registrationController;

    @Test
    public void testRegisterSuccess() {
        RegistrationDTO registrationDTO = RegistrationDTO.builder()
                .email("sample@gmail.com")
                .userName("sample")
                .name("sample")
                .password("1233")
                .build();

        UserDTO userDTO = UserDTO.builder()
                .id(1l)
                .email("sample@gmail.com")
                .userName("sample")
                .name("sample")
                .build();

        when(registrationService.register(registrationDTO)).thenReturn(userDTO);

        ResponseEntity<UserDTO> responseEntity = registrationController.register(registrationDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(userDTO, responseEntity.getBody());
    }
}