package io.book.library.application.dto;

import io.book.library.application.dto.Abstraction.AbstractDTO;
import io.book.library.domain.entities.Book;

import java.time.LocalDateTime;

public class UserDTO extends AbstractDTO {

    private String userName;
    private String CPF;
    private String userAddress;
    private String userEmail;
    private Book book;
    private LocalDateTime createdAt;


    public UserDTO(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, createdAt, updatedAt);
    }
}
