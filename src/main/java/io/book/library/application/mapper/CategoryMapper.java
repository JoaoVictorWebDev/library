package io.book.library.application.mapper;

import io.book.library.application.dto.CategoryDTO;
import io.book.library.domain.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryToCategoryDTO(Category category);

    List<CategoryDTO> updateList(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    CategoryDTO updateCategoryFromDTO(CategoryDTO dto, @MappingTarget Category category);
}

