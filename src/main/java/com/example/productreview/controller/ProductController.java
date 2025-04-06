package com.example.productreview.controller;

import com.example.productreview.model.dto.PopularProductsResponse;
import com.example.productreview.model.dto.ProductDto;
import com.example.productreview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        ProductDto createdProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name) {
        List<ProductDto> products = productService.findProducts(code, name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/popular")
    public ResponseEntity<PopularProductsResponse> getPopularProducts() {
        PopularProductsResponse response = productService.getPopularProducts();
        return ResponseEntity.ok(response);
    }
}