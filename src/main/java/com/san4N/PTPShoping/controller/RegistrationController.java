package com.san4N.PTPShoping.controller;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.dto.UserDTO;
import com.san4N.PTPShoping.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/registration")
@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<UserDTO> register(@Valid @RequestBody RegistrationDTO registrationDTO){
        UserDTO userDTO = registrationService.register(registrationDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

}
