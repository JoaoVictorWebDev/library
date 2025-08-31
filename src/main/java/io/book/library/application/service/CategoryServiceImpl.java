package io.book.library.application.service;

import io.book.library.application.dto.CategoryDTO;
import io.book.library.application.mapper.CategoryMapper;
import io.book.library.application.service.interfaces.CategoryService;
import io.book.library.domain.entities.Author;
import io.book.library.domain.entities.Category;
import io.book.library.infrastructure.config.EntityNotFoundException;
import io.book.library.infrastructure.repository.ICategoryRepository;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Autowired
    private CategoryMapper mapper;

    public CategoryDTO createCategory(Category category) {
        Category categorySave = repository.save(category);
        return mapper.categoryToCategoryDTO(categorySave);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> category = repository.findAll();
        return mapper.updateList(category);
    }

    public Optional<CategoryDTO> getCategoryById(Long categoryId) {

        return repository.findById(categoryId).map(mapper::categoryToCategoryDTO);
    }

    public CategoryDTO updateCategory(Long categoryId, CategoryDTO category) {

        Category categoryUpdate = (repository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found")));
        mapper.updateCategoryFromDTO(category, categoryUpdate);
        return mapper.categoryToCategoryDTO(categoryUpdate);
    }

    public void deleteByIdCategory(Long categoryId) {
        if (!repository.existsById(categoryId))
            throw new EntityNotFoundException("User with that id not exists " + categoryId);
        repository.deleteById(categoryId);
    }

    public Optional<CategoryDTO> getCategoryByName(String categoryName) {

        return repository.getCategoryByName(categoryName).map(mapper::categoryToCategoryDTO);
    }
}
