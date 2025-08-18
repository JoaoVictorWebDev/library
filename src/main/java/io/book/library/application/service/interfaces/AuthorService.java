package io.book.library.application.service.interfaces;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {

    AuthorDTO createAuthor(Author author);

    AuthorDTO updateAuthor(Long authorID, AuthorDTO authorDTO);

    void deleteAuthor(Long authorID);

    AuthorDTO getAuthorById(Long authorId);

    List<AuthorDTO> getAllAuthors();

    List<AuthorDTO> findAllAuthorsByNationality(String nationality);

    List<AuthorDTO> findAuthorsByBirthDate(LocalDate birthDate);

    List<AuthorDTO> searchAuthorsByName(String name);

}
