package com.san4N.PTPShoping.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDTO(Long id,
                      String name,
                      String email,
                      String userName,

                      @NotNull @Min(0)
                      Integer modRev) {
}
