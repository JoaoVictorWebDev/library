package io.book.library.infrastructure.repository;

import io.book.library.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
