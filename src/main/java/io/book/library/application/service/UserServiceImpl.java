package io.book.library.application.service;

import io.book.library.application.dto.BookDTO;
import io.book.library.application.dto.UserDTO;
import io.book.library.application.mapper.BookMapper;
import io.book.library.application.mapper.UserMapper;
import io.book.library.application.service.interfaces.BookService;
import io.book.library.application.service.interfaces.UserService;
import io.book.library.domain.entities.Book;
import io.book.library.domain.entities.User;
import io.book.library.domain.enums.BookStatus;
import io.book.library.domain.enums.UserStatus;
import io.book.library.infrastructure.config.EntityNotFoundException;
import io.book.library.infrastructure.config.IllegalStateException;
import io.book.library.infrastructure.repository.IBookRepository;
import io.book.library.infrastructure.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Transactional
    public UserDTO createUser(User user){

        user.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(user);
        return userMapper.userToDTO(user);
    }

    @Transactional
    public UserDTO assignBookToUser(Long userId, Long bookId)
    {

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not Found"));
        Book book = bookService.markAsRented(bookId);
        user.setBook(book);
        userRepository.save(user);
        return userMapper.userToDTO(user);
    }

    @Transactional
    public void deleteUserById(Long userId) {

        if(!userRepository.existsById(userId))
            throw new EntityNotFoundException("User not found");
        userRepository.deleteById(userId);
    }

    @Transactional
    public Optional<User> findUserById(Long userId) {
        return Optional.ofNullable(userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not Found")));
    }

    @Transactional
    public Optional<UserDTO> ReturnBook(Long userId, Long bookId) {
        User user = userRepository.findIdWithBook(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if(user.getBook() == null || !user.getBook().getBookID().equals(bookId)){
            throw new IllegalStateException("That book wasn't rented by that user");
        }

        Book book = user.getBook();
        book.setBookStatus(BookStatus.RETURNED);
        book.setReturnDate(LocalDate.now());

        bookRepository.save(book);
        userRepository.save(user);
        return Optional.ofNullable(userMapper.userToDTO(user));
    }

    @Transactional
    public List<BookDTO> booksRented(){
        List<Book> rentedBooks = bookRepository.findAll()
                .stream()
                .filter(m -> m.getBookStatus() == BookStatus.RENTED)
                .toList();
        return rentedBooks.stream().map(bookMapper::bookToDTO).toList();
    }

    @Transactional
    public List<UserDTO> getAllUserLoans() {
        List<User> userLoans  = userRepository.getAllUserLoans();
        return userMapper.userListToDTO(userLoans);
    }

    @Override
    public boolean activeOrDeactiveUserAccount() {
        return false;
    }

    @Transactional
    public List<UserDTO> getUserLoanById(Long loanId){

        List<User> user  = userRepository.findLoanByUserId(loanId);
        return userMapper.userListToDTO(user);
    }

    @Transactional
    public User verifiyUserAccount(User user) {
        if(user.getUserStatus() == UserStatus.ACTIVE)
            return user;
    return null;
    }

    public User exportUserReport() {
        return null;
    }
}
