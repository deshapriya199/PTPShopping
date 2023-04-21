package com.san4N.PTPShoping.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegistrationDTO(
        @NotNull @Size(min = 2, max = 14)
        String name,
        String email,
        String userName,
        String password) {
}
