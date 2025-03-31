package ru.vsu.cake_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Getter @Setter @Accessors(fluent = true)
@NoArgsConstructor @AllArgsConstructor @Builder
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_category_id"))
    private Category category;
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
