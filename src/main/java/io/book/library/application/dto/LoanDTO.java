package io.book.library.application.dto;

import io.book.library.domain.entities.Book;
import io.book.library.domain.entities.User;
import io.book.library.domain.enums.BookStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record LoanDTO(Book book, User user, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate, LocalDate returned,
                     BigDecimal fine,
         String notes,
         BookStatus bookStatus,
         LocalDateTime createdAt)
{

}
