package io.book.library.application.dto;

import io.book.library.domain.entities.Book;

import java.time.LocalDateTime;

public record UserDTO(String userName, String CPF, String userAddress, String userEmail, Book book, LocalDateTime createdAt){

}
