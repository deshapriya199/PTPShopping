package com.san4N.PTPShoping.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistrationDTO(
        Long id,

        @NotNull @Size(min = 2, max = 14)
        String name,
        String email,
        String userName,
        String password) {
}
