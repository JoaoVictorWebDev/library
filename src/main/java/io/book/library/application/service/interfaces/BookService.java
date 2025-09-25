package io.book.library.application.service.interfaces;

import io.book.library.application.dto.BookDTO;
import io.book.library.domain.entities.Book;
import io.book.library.domain.enums.BookStatus;
import io.book.library.infrastructure.config.dto.SendMessageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDTO markAsRented(Long bookId);

    BookDTO addBook(Book book, SendMessageRequest messageRequest);

    BookDTO updateBook(Long bookId, BookDTO bookDTO);

    void deleteBook(Long bookId);

    Optional<BookDTO> getBookById(Long bookId);

    Page<BookDTO> getAllBooks(Pageable pageable);

    List<BookDTO> findBooksByTitle(String bookName);

    List<BookDTO> findBooksByAuthor(String authorName);

    List<BookDTO> findBooksByCategory(String categoryName);

    List<BookDTO> findBooksByPublishedDate(LocalDate publishedDate);

    BookDTO markAsReturned(Long bookId);

    List<BookDTO> getAvailableBooks();

    List<BookDTO> getRentedBooks();

    List<BookDTO> getOverdueBooks();

    BookDTO updateBookStatus(Long bookId, BookStatus status);
}


