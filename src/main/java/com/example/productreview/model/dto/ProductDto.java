package com.example.productreview.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    @NotBlank
    @Size(min = 15, max = 15, message = "Code must be exactly 15 characters")
    private String code;

    @NotBlank
    private String name;

    @PositiveOrZero
    private BigDecimal priceEur;

    private BigDecimal priceUsd;

    private String description;
}