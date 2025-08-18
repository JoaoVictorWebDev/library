package io.book.library.application.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AuthorDTO(Long authorID, String authorName, String nationality, String biography, String photoUrl, LocalDate birthDate
, LocalDateTime createdAt) {
}
