package io.book.library.application.dto.Abstraction;

import java.time.LocalDateTime;

public abstract class AbstractDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public AbstractDTO(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

