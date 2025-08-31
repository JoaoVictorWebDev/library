package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByNationality(String nationality);
    List<Author> findAuthorByBirthDate(LocalDate birthDate);
    List<Author> findAuthorByName(String authorName);
}
