package com.example.productreview.repository;

import com.example.productreview.model.Review;
import com.example.productreview.model.dto.PopularProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT new com.example.productreview.model.dto.PopularProductDto(p.name, ROUND(AVG(r.rating), 1)) " +
            "FROM Review r JOIN r.product p " +
            "GROUP BY p.id, p.name " +
            "ORDER BY AVG(r.rating) DESC")
    List<PopularProductDto> findTopProductsByAverageRating();
}