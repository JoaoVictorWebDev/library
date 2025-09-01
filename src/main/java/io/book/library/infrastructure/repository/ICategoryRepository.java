package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c from Category c WHERE c.categoryName = :categoryName")
    Optional<Category> getCategoryByName(@Param("categoryName") String categoryName);

}
