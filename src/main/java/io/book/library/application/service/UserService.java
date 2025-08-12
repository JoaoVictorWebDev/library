package io.book.library.application.service;

import io.book.library.domain.entities.Book;
import io.book.library.domain.entities.User;

import java.util.List;

public interface UserService {

    User assignBookToUser(Long userId, Long bookId);

    void deleteUserById(Long userId);

    User findUserById(Long id);

    User ReturnBook(User user, Book bookid);

    List<Book> booksRented(Book book);

    List<User> getAllUserLoans(User user);

    boolean activeOrDeactiveUserAccount();

    User verifiyUserAccount(User user);

    User exportUserReport();
}
