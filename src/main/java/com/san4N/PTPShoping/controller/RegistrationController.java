package com.san4N.PTPShoping.controller;

import com.san4N.PTPShoping.dto.RegistrationDTO;
import com.san4N.PTPShoping.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<String> register(@RequestBody RegistrationDTO registrationDTO){
        registrationService.register(registrationDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
