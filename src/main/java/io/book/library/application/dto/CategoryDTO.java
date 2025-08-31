package io.book.library.application.dto;

import io.book.library.application.dto.Abstraction.AbstractDTO;

import java.time.LocalDateTime;

public class CategoryDTO extends AbstractDTO {

    private String categoryName;

    public CategoryDTO(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, createdAt, updatedAt);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
