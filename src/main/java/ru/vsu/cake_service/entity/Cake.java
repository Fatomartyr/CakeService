package ru.vsu.cake_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price", precision = 7, scale = 2)
    private BigDecimal price;
    @Column(name = "weight", precision = 5, scale = 2)
    private BigDecimal weight;
    @Column(name = "filling")
    private String filling;
    @Column(name = "topping")
    private String topping;
    @Column(name = "image_url")
    private String imageUrl;
}
