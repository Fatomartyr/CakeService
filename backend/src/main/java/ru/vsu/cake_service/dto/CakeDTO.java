package ru.vsu.cake_service.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public record CakeDTO(
        @NotBlank(message = "Name cannot be empty") String name,
        @NotBlank(message = "Description cannot be empty") String description,
        @Digits(integer = 7, fraction = 2, message =
                "Price must follow the rule: integer = 7, scale = 2")
        BigDecimal price,
        @Digits(integer = 5, fraction = 2, message =
                "Weight must follow the rule: integer = 5, scale = 2")
        BigDecimal weight,
        @NotBlank(message = "Filling cannot be empty") String filling,
        String topping,
        String imageUrl
) {
}
