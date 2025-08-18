package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.Book_ID where u.id = :userId ")
    Optional<User> findIdWithBook(@Param("userId") Long userId);
    
    @Query("SELECT u.* " + "FROM users u " + "LEFT JOIN loan l ON l.User_id = u.User_id")
    List<User> getAllUserLoans();
    
    @Query(value = "SELECT u.* " + "FROM users u " + "LEFT JOIN Loan l  ON l.User_ID = u.User_id " + "WHERE l.id = :loanID", nativeQuery = true)
    List<User> findLoanByUserId(@Param("userId") Long LoanId);
}
