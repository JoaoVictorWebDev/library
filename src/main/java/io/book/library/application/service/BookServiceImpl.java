package io.book.library.application.service;

import io.book.library.application.dto.BookDTO;
import io.book.library.application.mapper.BookMapper;
import io.book.library.application.service.interfaces.BookService;
import io.book.library.domain.entities.Book;
import io.book.library.domain.enums.BookStatus;
import io.book.library.infrastructure.config.adapter.ZApiAdapter;
import io.book.library.infrastructure.config.dto.SendMessageRequest;
import io.book.library.infrastructure.config.exceptions.IllegalStateException;
import io.book.library.infrastructure.repository.IBookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private IBookRepository repository;

    @Autowired
    private BookMapper mapper;

    @Autowired
    private ZApiAdapter adapter;


    public BookDTO markAsRented(Long bookId) {
        Book book = repository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book Not Found"));

        if (book.getBookStatus() == BookStatus.RENTED) throw new IllegalStateException("That book was Rented!");
        book.setBookStatus(BookStatus.RENTED);
        Book bookSave = repository.save(book);
        return mapper.bookToDTO(bookSave);
    }

    @Override
    public BookDTO addBook(Book book, SendMessageRequest messageRequest) {
        Book bookSave = repository.save(book);
        adapter.sendMessage(messageRequest);
        return mapper.bookToDTO(bookSave);
    }


    @Transactional
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        Book book = repository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (!repository.existsById(bookId)) throw new IllegalStateException("Book doesn't exists");

        mapper.updateBookFromDTO(bookDTO, book);

        bookDTO.setUpdatedAt(LocalDateTime.now());
        Book save = repository.save(book);

        return mapper.bookToDTO(save);
    }

    @Override
    public void deleteBook(Long bookId) {

        if (!repository.existsById(bookId)) throw new IllegalStateException("That book doesnt exists!");

        repository.deleteById(bookId);
    }

    @Override
    public Optional<BookDTO> getBookById(Long bookId) {

        Optional<Book> book = Optional.ofNullable(repository.findById(bookId)).orElseThrow(() -> new EntityNotFoundException("Book with this ID doesnt exists"));
        return mapper.map(book);
    }

    @Override
    public Page<BookDTO> getAllBooks(Pageable pageable) {
        Page<Book> book = repository.findAll(pageable);
        return book.map(mapper::bookToDTO);
    }

    @Override
    public List<BookDTO> findBooksByTitle(String bookName) {
        Optional<Book> book = repository.findBooksByTitle(bookName);
        return book.stream().map(mapper::bookToDTO).toList();
    }

    @Override
    public List<BookDTO> findBooksByAuthor(String author) {
        List<Book> book = repository.findBooksByAuthor(author);
        return book.stream().map(mapper::bookToDTO).toList();
    }

    @Override
    public List<BookDTO> findBooksByCategory(String category) {
        List<Book> book = repository.findBooksByCategory(category);
        return book.stream().map(mapper::bookToDTO).toList();
    }

    @Override
    public List<BookDTO> findBooksByPublishedDate(LocalDate publishedDate) {
        Optional<Book> book = repository.findBooksByPublishedDate(publishedDate);
        return book.stream().map(mapper::bookToDTO).toList();
    }

    @Override
    public BookDTO markAsReturned(Long bookId) {

        Book book = repository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("That book was not find"));

        if (book.getBookStatus() == BookStatus.RETURNED)
            throw new IllegalStateException("That book was already returned");
        book.setBookStatus(BookStatus.RETURNED);
        Book bookSave = repository.save(book);

        return mapper.bookToDTO(bookSave);
    }

    public List<BookDTO> getAvailableBooks() {

        List<Book> book = repository.getAvailableBooks(BookStatus.RETURNED);
        return book.stream().map(mapper::bookToDTO).toList();
    }

    @Override
    public List<BookDTO> getRentedBooks() {

        List<Book> book = repository.getAvailableBooks(BookStatus.RENTED);
        return book.stream().map(mapper::bookToDTO).toList();
    }

    @Override
    public List<BookDTO> getOverdueBooks() {
        return List.of();
    }

    @Override
    public BookDTO updateBookStatus(Long bookId, BookStatus status) {
        return null;
    }
}
