package ru.vsu.cake_service.dto;


import java.math.BigDecimal;

public record CakeDTO(
        String name,
        String description,
        BigDecimal price,
        BigDecimal weight,
        String filling,
        String topping,
        String imageUrl
) {
}
