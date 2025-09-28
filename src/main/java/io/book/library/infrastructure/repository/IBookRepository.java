package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.Book;
import io.book.library.domain.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT bk FROM Book bk WHERE bk.bookName = :bookName ")
    Optional<Book> findBooksByTitle(@Param("bookName") String bookName);

    @Query("SELECT bk FROM Book bk WHERE bk.author.id = :authorId ")
    List<Book> findBooksByAuthor(@Param("authorId") Long authorId);

    @Query("SELECT bk from Book bk WHERE bk.category = :category")
    List<Book> findBooksByCategory(@Param("category") String category);

    @Query("SELECT bk from Book bk WHERE bk.publishedDate = :publishedDate")
    Optional<Book> findBooksByPublishedDate(@Param("publishedDate") LocalDate publishedDate);

    @Query("SELECT bk from Book bk WHERE bk.bookStatus = :status")
    List<Book> getAvailableBooks(@Param("status") BookStatus status);

    @Query("SELECT bk from Book bk WHERE bk.bookStatus = :status")
    List<Book> getRentedBooks(@Param("status") BookStatus status);
}
