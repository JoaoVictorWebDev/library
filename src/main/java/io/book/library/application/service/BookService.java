package io.book.library.application.service;

import io.book.library.domain.entities.Book;

public interface BookService {
    Book markAsRented(Long bookId);}

