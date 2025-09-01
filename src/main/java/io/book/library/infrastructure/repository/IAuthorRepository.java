package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface    IAuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByNationality(String nationality);

    List<Author> findAuthorByBirthDate(LocalDate birthDate);

    @Query("SELECT a FROM Author a")
    Page<Author> findAllAuthors(Pageable pageable);

    @Query("SELECT a FROM Author a WHERE a.authorName = :name")
    List<Author> findAuthorByName(@Param("name") String authorName);
}
