package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.Book  where u.UserID = :userId ")
    Optional<User> findIdWithBook(@Param("userId") Long userId);

    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.loans")
    List<User> getAllUserLoans();

    @Query(value = "SELECT u.* " + "FROM users u " + "LEFT JOIN Loan l  ON l.User_ID = u.User_id " + "WHERE l.id = :loanID", nativeQuery = true)
    List<User> findLoanByUserId(@Param("userId") Long LoanId);
}
