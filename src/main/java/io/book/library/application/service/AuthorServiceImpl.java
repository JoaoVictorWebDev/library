package io.book.library.application.service;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.application.mapper.AuthorMapper;
import io.book.library.application.service.interfaces.AuthorService;
import io.book.library.domain.entities.Author;
import io.book.library.infrastructure.config.EntityNotFoundException;
import io.book.library.infrastructure.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private IAuthorRepository repository;

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired

    public AuthorDTO createAuthor(Author author) {

        Author authorSaved = repository.save(author);
        return  authorMapper.authorToDTO(authorSaved);
    }

    public AuthorDTO updateAuthor(Long authorID, AuthorDTO authorDTO) {
        Author author = repository.findById(authorID)
                .orElseThrow(() -> new EntityNotFoundException("User not Found !"));
        authorMapper.updateAuthorFromDTO(authorDTO, author);
        Author uptaded = repository.save(author);
        return authorMapper.authorToDTO(uptaded);
    }

    public void deleteAuthor(Long authorID) {

        if( authorID == null){
            throw new IllegalStateException("Author cannot  be null!!");
        }

        repository.findById(authorID).orElseThrow(() -> new EntityNotFoundException("User not found"));
        repository.deleteById(authorID);
    }

    public AuthorDTO getAuthorById(Long authorId) {
        return null;
    }

    public List<AuthorDTO> getAllAuthors() {
        return List.of();
    }

    public List<AuthorDTO> findAllAuthorsByNationality(String nationality) {
        return List.of();
    }

    public List<AuthorDTO> findAuthorsByBirthDate(LocalDate birthDate) {
        return List.of();
    }

    public List<AuthorDTO> searchAuthorsByName(String name) {
        return List.of();
    }
}
