package io.book.library.application.service;

import io.book.library.application.service.interfaces.BookService;
import io.book.library.domain.entities.Book;
import io.book.library.domain.enums.BookStatus;
import io.book.library.infrastructure.config.IllegalStateException;
import io.book.library.infrastructure.repository.IBookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    protected IBookRepository repository;

    public Book markAsRented(Long bookId){
        Book book = repository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book Not Found"));
        if(book.getBookStatus() == BookStatus.RENTED){
            throw new IllegalStateException("That book was Rented!");
        }
        book.setBookStatus(BookStatus.RENTED);
        return repository.save(book);
    }
}
