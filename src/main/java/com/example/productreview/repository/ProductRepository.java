package com.example.productreview.repository;

import com.example.productreview.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);

    @Query("SELECT p FROM Product p WHERE " +
            "(:code IS NULL OR LOWER(p.code) LIKE LOWER(CONCAT('%', :code, '%'))) AND " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    List<Product> findByCodeAndNameContainingIgnoreCase(
            @Param("code") String code,
            @Param("name") String name);

    boolean existsByCode(String code);
}