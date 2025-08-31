package io.book.library.application.service.interfaces;

import io.book.library.application.dto.CategoryDTO;
import io.book.library.domain.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDTO createCategory(Category category);

    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> getCategoryById(Long categoryId);

    CategoryDTO updateCategory(Long categoryId, CategoryDTO category);

    void deleteByIdCategory(Long categoryId);

    Optional<CategoryDTO> getCategoryByName(String categoryName);
}
