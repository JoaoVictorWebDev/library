package io.book.library.api;

import io.book.library.application.dto.AuthorDTO;
import io.book.library.application.service.interfaces.AuthorService;
import io.book.library.domain.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/library/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping("createAuthor")
    public ResponseEntity<AuthorDTO> createAuthor(Author author) {
        AuthorDTO createdDTO = service.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @GetMapping("getAuthorByID/{id}")
    public ResponseEntity<AuthorDTO> getAuthorByID(@PathVariable Long id) {
        AuthorDTO authorDTO = service.getAuthorById(id);
        return ResponseEntity.ok(authorDTO);
    }

    @DeleteMapping("deleteAuthor/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

}
