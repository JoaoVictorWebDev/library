package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
