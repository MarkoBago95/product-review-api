package com.example.productreview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 15, nullable = false)
    @NotBlank
    @Size(min = 15, max = 15, message = "Code must be exactly 15 characters")
    private String code;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(name = "price_eur", nullable = false)
    @PositiveOrZero
    private BigDecimal priceEur;

    @Column(name = "price_usd", nullable = false)
    @PositiveOrZero
    private BigDecimal priceUsd;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();
}