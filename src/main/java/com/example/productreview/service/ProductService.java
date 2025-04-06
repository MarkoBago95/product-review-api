package com.example.productreview.service;

import com.example.productreview.exception.InvalidProductDataException;
import com.example.productreview.model.Product;
import com.example.productreview.model.dto.PopularProductDto;
import com.example.productreview.model.dto.PopularProductsResponse;
import com.example.productreview.model.dto.ProductDto;
import com.example.productreview.repository.ProductRepository;
import com.example.productreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ProductService(
            ProductRepository productRepository,
            ReviewRepository reviewRepository,
            ExchangeRateService exchangeRateService
    ) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
        this.exchangeRateService = exchangeRateService;
    }

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        if (productRepository.existsByCode(productDto.getCode())) {
            throw new InvalidProductDataException("Product with code " + productDto.getCode() + " already exists");
        }
        productDto.setPriceUsd(exchangeRateService.convertEurToUsd(productDto.getPriceEur()));
        Product product = mapToEntity(productDto);
        Product savedProduct = productRepository.save(product);

        return mapToDto(savedProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductDto> findProducts(String code, String name) {
        List<Product> products = productRepository.findByCodeAndNameContainingIgnoreCase(code, name);
        return products.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PopularProductsResponse getPopularProducts() {
        List<PopularProductDto> topProducts = reviewRepository.findTopProductsByAverageRating();
        List<PopularProductDto> top3Products = topProducts.stream()
                .limit(3)
                .collect(Collectors.toList());

        return new PopularProductsResponse(top3Products);
    }

    private Product mapToEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .name(dto.getName())
                .priceEur(dto.getPriceEur())
                .priceUsd(dto.getPriceUsd())
                .description(dto.getDescription())
                .build();
    }

    private ProductDto mapToDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .priceEur(entity.getPriceEur())
                .priceUsd(entity.getPriceUsd())
                .description(entity.getDescription())
                .build();
    }
}