package com.san4n.ptpshopping.dto;

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
