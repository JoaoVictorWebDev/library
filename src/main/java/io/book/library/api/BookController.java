package io.book.library.api;

import io.book.library.application.dto.BookDTO;
import io.book.library.application.service.interfaces.BookService;
import io.book.library.domain.entities.Book;
import io.book.library.infrastructure.config.dto.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/library/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public ResponseEntity<BookDTO> addBook(@RequestBody Book book) {
        SendMessageRequest request = new SendMessageRequest(
                "5521994117244",
                "O livro " + book.getBookName() + " foi atualizado com sucesso!"
        );
        BookDTO savedBook = service.addBook(book, request);
        return new ResponseEntity<BookDTO>(savedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {

        BookDTO updatedBook = service.updateBook(id, bookDTO);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Optional<BookDTO> dto = service.getBookById(id);
        return dto.map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<Page<BookDTO>> getAllBooks(Pageable pageable) {
        Page<BookDTO> allBooks = service.getAllBooks(pageable);
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/getBooksByTitle/{bookName}")
    public ResponseEntity<List<BookDTO>> getBooksByTitle(@PathVariable String bookName) {
        List<BookDTO> book = service.findBooksByTitle(bookName);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getBooksByAuthor/{authorId}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable Long authorId) {
        List<BookDTO> book = service.findBooksByAuthor(authorId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getBooksByCategory/{categoryName}")
    public ResponseEntity<List<BookDTO>> getBooksByCategory(@PathVariable String categoryName) {
        List<BookDTO> book = service.findBooksByCategory(categoryName);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getBooksByPublishedDate/{publishedDate}")
    public ResponseEntity<List<BookDTO>> getBooksByPublishedDate(@PathVariable LocalDate publishedDate) {
        List<BookDTO> book = service.findBooksByPublishedDate(publishedDate);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
