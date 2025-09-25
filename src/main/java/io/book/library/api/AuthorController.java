package io.book.library.api;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.application.service.interfaces.AuthorService;
import io.book.library.domain.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/library/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping("createAuthor")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody Author author) {
        AuthorDTO createdDTO = service.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @GetMapping("getAuthorByID/{id}")
    public ResponseEntity<AuthorDTO> getAuthorByID(@PathVariable Long id) {
        AuthorDTO authorDTO = service.getAuthorById(id);
        return ResponseEntity.ok(authorDTO);
    }

    @GetMapping("getAllAuthors")
    public ResponseEntity<Page<AuthorDTO>> getAllAuthors(Pageable pageable) {
        Page<AuthorDTO> authors = service.getAllAuthors(pageable);
        return ResponseEntity.ok(authors);
    }

    @DeleteMapping("deleteAuthor/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAllAuthorsByNationality/{nationality}")
    public ResponseEntity<List<AuthorDTO>> findAuthorsByNationality(@PathVariable String nationality) {

        List<AuthorDTO> author = service.findAllAuthorsByNationality(nationality);
        return ResponseEntity.ok(author);
    }

    @GetMapping("getAuthorByBirthDate/{birthDate}")
    public ResponseEntity<List<AuthorDTO>> findAuthorsByBirthDate(@PathVariable LocalDate birthDate) {

        List<AuthorDTO> dto = service.findAuthorsByBirthDate(birthDate);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("searchAuthorsByName/{authorName}")
    public ResponseEntity<List<AuthorDTO>> searchAuthorsByName(@PathVariable String authorName) {

        List<AuthorDTO> dto = service.findAuthorsByName(authorName);
        return ResponseEntity.ok(dto);
    }
}
