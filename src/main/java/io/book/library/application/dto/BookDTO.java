package io.book.library.application.dto;

import io.book.library.domain.entities.Author;
import io.book.library.domain.entities.Category;
import io.book.library.domain.enums.BookStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookDTO(String bookName, Author author, Category category, Integer pages, private String coverImageUrl, String summary,
                      LocalDate publishedDate, LocalDate returnDate, LocalDate dueDate, LocalDateTime createdAt, LocalDateTime updateAt,
                      BookStatus bookStatus) {
}
