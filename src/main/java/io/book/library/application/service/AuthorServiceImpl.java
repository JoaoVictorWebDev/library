package io.book.library.application.service;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.application.dto.BookDTO;
import io.book.library.application.mapper.AuthorMapper;
import io.book.library.application.service.interfaces.AuthorService;
import io.book.library.domain.entities.Author;
import io.book.library.domain.entities.Book;
import io.book.library.infrastructure.config.exceptions.EntityNotFoundException;
import io.book.library.infrastructure.repository.IAuthorRepository;
import io.book.library.infrastructure.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private IAuthorRepository repository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private IBookRepository bookRepository;

    public AuthorDTO createAuthor(Author author) {

        Author authorSaved = repository.save(author);
        return authorMapper.authorToDTO(authorSaved);
    }

    public AuthorDTO updateAuthor(Long authorID, AuthorDTO authorDTO) {
        Author author = repository.findById(authorID)
                .orElseThrow(() -> new EntityNotFoundException("User not Found !"));
        authorMapper.updateAuthorFromDTO(authorDTO, author);
        Author uptaded = repository.save(author);
        return authorMapper.authorToDTO(uptaded);
    }

    public void deleteAuthor(Long authorID) {

        if (authorID == null) {
            throw new IllegalStateException("Author cannot  be null!!");
        }

        repository.findById(authorID).orElseThrow(() -> new EntityNotFoundException("User not found"));
        repository.deleteById(authorID);
    }

    public AuthorDTO getAuthorById(Long authorId) {

        if (!repository.existsById(authorId))
            throw new EntityNotFoundException("Author is null");
        Author author = repository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("User not Found"));
        return authorMapper.authorToDTO(author);
    }

    @Transactional(readOnly = true)
    public Page<AuthorDTO> getAllAuthors(Pageable page) {
        Page<Author> author = repository.findAllAuthors(page);
        return author.map(authorMapper::authorToDTO);
    }

    public List<AuthorDTO> findAllAuthorsByNationality(String nationality) {
        List<Author> authors = repository.findAllByNationality(nationality);
        return authorMapper.authorListToDTO(authors);
    }

    public List<AuthorDTO> findAuthorsByBirthDate(LocalDate birthDate) {
        List<Author> author = repository.findAuthorByBirthDate(birthDate);
        return authorMapper.authorListToDTO(author);
    }

    public List<AuthorDTO> findAuthorsByName(String authorName) {
        List<Author> authors = repository.findAuthorByName(authorName);
        return authorMapper.authorListToDTO(authors);
    }
}
