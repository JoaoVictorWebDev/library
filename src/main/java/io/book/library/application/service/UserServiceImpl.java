package io.book.library.application.service;

import io.book.library.domain.entities.Book;
import io.book.library.domain.entities.User;
import io.book.library.domain.enums.BookStatus;
import io.book.library.infrastructure.config.EntityNotFoundException;
import io.book.library.infrastructure.config.IllegalStateException;
import io.book.library.infrastructure.repository.IBookRepository;
import io.book.library.infrastructure.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Transactional
    public User assignBookToUser(Long userId, Long bookId)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not Found"));
        Book book = bookService.markAsRented(bookId);
        userRepository.save(user);
        user.setBook(book);
        return user;
    }

    public void deleteUserById(Long userId) {
    }

    public User findUserById(Long id) {
        return null;
    }

    public User ReturnBook(User user, Book bookid) {
        return null;
    }

    public List<Book> booksRented(Book book) {
        return List.of();
    }

    public List<User> getAllUserLoans(User user) {
        return List.of();
    }

    public boolean activeOrDeactiveUserAccount() {
        return false;
    }

    public User verifiyUserAccount(User user) {
        return null;
    }

    public User exportUserReport() {
        return null;
    }
}
