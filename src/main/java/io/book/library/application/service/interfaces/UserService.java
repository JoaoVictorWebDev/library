package io.book.library.application.service.interfaces;

import io.book.library.application.dto.BookDTO;
import io.book.library.application.dto.UserDTO;
import io.book.library.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO createUser(User user);

    UserDTO assignBookToUser(Long userId, Long bookId);

    void deleteUserById(Long userId);

    Optional<User> findUserById(Long id);

    Optional<UserDTO> ReturnBook(Long userId, Long bookId);

    List<BookDTO> booksRented();

    List<UserDTO> getAllUserLoans();

    boolean activeOrDeactiveUserAccount();

    User verifiyUserAccount(User user);

    User exportUserReport();
}
